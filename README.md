# 🍕 Food Delivery Application

A complete food delivery web application built with Spring Boot, allowing users to browse restaurants, order food, and make payments online.

## 🚀 Features

### 👤 User Features
- **User Registration & Login** - Secure authentication using Spring Security
- **Browse Products** - View all available food items with images
- **Category Filtering** - Filter products by category (Pizza, Burger, Sushi, etc.)
- **Shopping Cart** - Add/remove items, update quantities
- **Multiple Payment Options**:
  - 💵 Cash on Delivery
  - 📱 UPI Payment (QR Code)
  - 💳 Credit/Debit Card
- **Order Management** - View order history and status
- **Order Success Page** - Confirmation with order details

### 🛠️ Technical Features
- MVC Architecture
- Spring Data JPA for database operations
- Spring Security for authentication
- Thymeleaf for server-side rendering
- Responsive Bootstrap UI
- QR Code generation for UPI payments
- Session-based cart management

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| **Spring Boot** | Backend framework |
| **Spring MVC** | Web layer |
| **Spring Data JPA** | Database operations |
| **Spring Security** | Authentication & Authorization |
| **Thymeleaf** | Template engine |
| **MySQL** | Database |
| **Bootstrap 5** | Frontend styling |
| **Font Awesome** | Icons |
| **Maven** | Build tool |
| **ZXing** | QR code generation |

## 📋 Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher
- Git (optional)



git clone https://github.com/abhishektyagi4727/Food_delivery-_Website.git
cd Food_delivery-_Website

src/main/java/com/fooddelivery/
├── controller/           # Web controllers
│   ├── AuthController.java
│   ├── HomeController.java
│   ├── CartController.java
│   ├── OrderController.java
│   └── UPIPaymentController.java
├── service/              # Business logic
│   ├── UserService.java
│   ├── ProductService.java
│   ├── CartService.java
│   ├── OrderService.java
│   └── UPIService.java
├── repository/           # Data access layer
│   ├── UserRepository.java
│   ├── ProductRepository.java
│   ├── CategoryRepository.java
│   └── OrderRepository.java
├── entity/               # JPA entities
│   ├── User.java
│   ├── Product.java
│   ├── Category.java
│   ├── Order.java
│   └── OrderItem.java
├── config/               # Configuration classes
│   ├── SecurityConfig.java
│   └── MvcConfig.java
├── model/                # DTOs and models
│   └── CartItem.java
└── loader/               # Data initializer
    └── DataLoader.java

src/main/resources/
├── templates/            # Thymeleaf templates
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── cart.html
│   ├── checkout.html
│   ├── orders.html
│   ├── order-success.html
│   └── upi-payment.html
├── static/               # Static resources
│   └── images/
│       └── uploads/      # Product images
└── application.properties # Application configuration
"# Food-delivery" 
