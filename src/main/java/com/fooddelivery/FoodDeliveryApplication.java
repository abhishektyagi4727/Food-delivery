package com.fooddelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodDeliveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryApplication.class, args);
        
        System.out.println("\n=========================================");
        System.out.println("🚀 FOOD DELIVERY APPLICATION STARTED!");
        System.out.println("🌐 URL: http://localhost:8080");
        System.out.println("👤 Admin: admin@fooddelivery.com / admin123");
        System.out.println("=========================================\n");
    }
}