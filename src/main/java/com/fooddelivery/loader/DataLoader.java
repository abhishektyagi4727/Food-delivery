package com.fooddelivery.loader;

import com.fooddelivery.entity.*;
import com.fooddelivery.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("\n=========================================");
        System.out.println("🚀 DATA LOADER STARTED");
        System.out.println("=========================================");
        
        try {
            // Load categories first and store them in a map
            Map<String, Category> categoryMap = loadCategories();
            
            // Load products using the category map
            loadProducts(categoryMap);
            
            // Load admin user
            loadAdminUser();
            
            System.out.println("\n✅ DATA LOADER COMPLETED SUCCESSFULLY");
            System.out.println("📊 Final Counts:");
            System.out.println("   - Categories: " + categoryRepository.count());
            System.out.println("   - Products: " + productRepository.count());
            System.out.println("   - Users: " + userRepository.count());
            System.out.println("=========================================\n");
            
        } catch (Exception e) {
            System.err.println("❌ Error in DataLoader: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private Map<String, Category> loadCategories() {
        Map<String, Category> categoryMap = new HashMap<>();
        
        if (categoryRepository.count() == 0) {
            System.out.println("\n📦 Loading categories...");
            
            Category pizza = new Category("Pizza");
            Category burger = new Category("Burger");
            Category sushi = new Category("Sushi");
            Category desserts = new Category("Desserts");
            Category beverages = new Category("Beverages");
            
            categoryRepository.save(pizza);
            categoryRepository.save(burger);
            categoryRepository.save(sushi);
            categoryRepository.save(desserts);
            categoryRepository.save(beverages);
            
            // Store in map for later use
            categoryMap.put("Pizza", pizza);
            categoryMap.put("Burger", burger);
            categoryMap.put("Sushi", sushi);
            categoryMap.put("Desserts", desserts);
            categoryMap.put("Beverages", beverages);
            
            System.out.println("✅ Categories loaded: Pizza, Burger, Sushi, Desserts, Beverages");
        } else {
            System.out.println("\n📦 Categories already exist. Loading from database...");
            
            // Load existing categories into map
            categoryRepository.findAll().forEach(category -> {
                categoryMap.put(category.getName(), category);
                System.out.println("   - Found category: " + category.getName());
            });
        }
        
        return categoryMap;
    }
    
    private void loadProducts(Map<String, Category> categoryMap) {
        if (productRepository.count() == 0) {
            System.out.println("\n🍽️ Loading products...");
            int productCount = 0;
            
            Category pizza = categoryMap.get("Pizza");
            Category burger = categoryMap.get("Burger");
            Category sushi = categoryMap.get("Sushi");
            Category desserts = categoryMap.get("Desserts");
            Category beverages = categoryMap.get("Beverages");
            
            // Check if all categories are available
            if (pizza == null || burger == null || sushi == null || desserts == null || beverages == null) {
                System.err.println("❌ Error: One or more categories not found!");
                System.err.println("   Pizza: " + (pizza != null ? "OK" : "MISSING"));
                System.err.println("   Burger: " + (burger != null ? "OK" : "MISSING"));
                System.err.println("   Sushi: " + (sushi != null ? "OK" : "MISSING"));
                System.err.println("   Desserts: " + (desserts != null ? "OK" : "MISSING"));
                System.err.println("   Beverages: " + (beverages != null ? "OK" : "MISSING"));
                return;
            }
            
            // Pizzas
            if (pizza != null) {
                productRepository.save(new Product(pizza, "Margherita Pizza", 
                    "Classic pizza with tomato sauce, mozzarella, and basil", 
                    new BigDecimal("12.99"), 
                    "https://images.pexels.com/photos/905847/pexels-photo-905847.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(pizza, "Pepperoni Pizza", 
                    "Pizza topped with pepperoni and cheese", 
                    new BigDecimal("14.99"), 
                    "https://images.pexels.com/photos/4109111/pexels-photo-4109111.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(pizza, "Vegetarian Pizza", 
                    "Pizza loaded with fresh vegetables", 
                    new BigDecimal("13.99"), 
                    "https://images.pexels.com/photos/803290/pexels-photo-803290.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                System.out.println("   ✅ Added 3 Pizza products");
            }
            
            // Burgers
            if (burger != null) {
                productRepository.save(new Product(burger, "Classic Burger", 
                    "Beef patty with lettuce, tomato, and cheese", 
                    new BigDecimal("9.99"), 
                    "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(burger, "Chicken Burger", 
                    "Grilled chicken with special sauce", 
                    new BigDecimal("8.99"), 
                    "https://images.pexels.com/photos/2338407/pexels-photo-2338407.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(burger, "Veggie Burger", 
                    "Plant-based patty with fresh vegetables", 
                    new BigDecimal("7.99"), 
                    "https://images.pexels.com/photos/3616956/pexels-photo-3616956.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                System.out.println("   ✅ Added 3 Burger products");
            }
            
            // Sushi
            if (sushi != null) {
                productRepository.save(new Product(sushi, "California Roll", 
                    "Crab, avocado, and cucumber roll", 
                    new BigDecimal("11.99"), 
                    "https://images.pexels.com/photos/792030/pexels-photo-792030.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(sushi, "Salmon Nigiri", 
                    "Fresh salmon on rice", 
                    new BigDecimal("13.99"), 
                    "https://images.pexels.com/photos/2323398/pexels-photo-2323398.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(sushi, "Vegetable Roll", 
                    "Assorted vegetables roll", 
                    new BigDecimal("10.99"), 
                    "https://images.pexels.com/photos/2098085/pexels-photo-2098085.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                System.out.println("   ✅ Added 3 Sushi products");
            }
            
            // Desserts
            if (desserts != null) {
                productRepository.save(new Product(desserts, "Chocolate Cake", 
                    "Rich chocolate layer cake", 
                    new BigDecimal("6.99"), 
                    "https://images.pexels.com/photos/1579926/pexels-photo-1579926.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(desserts, "Ice Cream", 
                    "Vanilla ice cream with toppings", 
                    new BigDecimal("4.99"), 
                    "https://images.pexels.com/photos/3630533/pexels-photo-3630533.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(desserts, "Cheesecake", 
                    "New York style cheesecake", 
                    new BigDecimal("7.99"), 
                    "https://images.pexels.com/photos/4040648/pexels-photo-4040648.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                System.out.println("   ✅ Added 3 Dessert products");
            }
            
            // Beverages
            if (beverages != null) {
                productRepository.save(new Product(beverages, "Cola", 
                    "Refreshing cola drink", 
                    new BigDecimal("2.99"), 
                    "https://images.pexels.com/photos/4113658/pexels-photo-4113658.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(beverages, "Fresh Juice", 
                    "Orange or apple juice", 
                    new BigDecimal("3.99"), 
                    "https://images.pexels.com/photos/338713/pexels-photo-338713.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                
                productRepository.save(new Product(beverages, "Mineral Water", 
                    "Natural mineral water", 
                    new BigDecimal("1.99"), 
                    "https://images.pexels.com/photos/416528/pexels-photo-416528.jpeg?auto=compress&cs=tinysrgb&w=600", 
                    ProductStatus.available));
                productCount++;
                System.out.println("   ✅ Added 3 Beverage products");
            }
            
            System.out.println("✅ Total products loaded: " + productCount);
            
        } else {
            System.out.println("\n🍽️ Products already exist. Total: " + productRepository.count());
            
            // Optional: Display existing products
            System.out.println("   Existing products:");
            productRepository.findAll().forEach(product -> {
                System.out.println("   - " + product.getName() + " (Category: " + 
                    (product.getCategory() != null ? product.getCategory().getName() : "No Category") + ")");
            });
        }
    }
    
    private void loadAdminUser() {
        if (userRepository.findByEmail("admin@fooddelivery.com").isEmpty()) {
            System.out.println("\n👤 Loading admin user...");
            
            User admin = new User();
            admin.setName("Administrator");
            admin.setEmail("admin@fooddelivery.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setPhone("1234567890");
            admin.setAddress("Admin Address");
            
            userRepository.save(admin);
            
            System.out.println("✅ Admin user loaded successfully!");
            System.out.println("   Email: admin@fooddelivery.com");
            System.out.println("   Password: admin123");
        } else {
            System.out.println("\n👤 Admin user already exists.");
        }
    }
}