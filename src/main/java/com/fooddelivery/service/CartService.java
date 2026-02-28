package com.fooddelivery.service;

import com.fooddelivery.entity.Product;
import com.fooddelivery.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class CartService {
    
    private List<CartItem> cartItems = new ArrayList<>();
    
    public void addToCart(Product product, int quantity) {
        // Check if product already exists in cart
        for (CartItem item : cartItems) {
            if (item.getProductId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        
        // Add new item to cart
        CartItem newItem = new CartItem(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getImage(),
            quantity
        );
        cartItems.add(newItem);
    }
    
    public void updateQuantity(Long productId, int quantity) {
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem item = cartItems.get(i);
            if (item.getProductId().equals(productId)) {
                if (quantity > 0) {
                    item.setQuantity(quantity);
                } else {
                    cartItems.remove(i);
                }
                return;
            }
        }
    }
    
    public void removeFromCart(Long productId) {
        cartItems.removeIf(item -> item.getProductId().equals(productId));
    }
    
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    
    public void clearCart() {
        cartItems.clear();
    }
    
    public int getCartCount() {
        return cartItems.size();
    }
    
    public int getTotalItems() {
        return cartItems.stream().mapToInt(CartItem::getQuantity).sum();
    }
    
    public BigDecimal getTotal() {
        return cartItems.stream()
            .map(CartItem::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}