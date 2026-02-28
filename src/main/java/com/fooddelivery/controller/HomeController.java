package com.fooddelivery.controller;

import com.fooddelivery.entity.Category;
import com.fooddelivery.entity.Product;
import com.fooddelivery.service.CategoryService;
import com.fooddelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "/index"})
    public String index(@RequestParam(value = "category", required = false) Long categoryId, Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Product> products;

        if (categoryId != null) {
            products = productService.getProductsByCategory(categoryId);
        } else {
            products = productService.getAllAvailableProducts();
        }

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("selectedCategory", categoryId);

        return "index";
    }
}