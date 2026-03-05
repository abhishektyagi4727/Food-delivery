-- =========================
-- Disable foreign key checks temporarily
-- =========================
SET FOREIGN_KEY_CHECKS = 0;

-- =========================
-- Insert Categories (ignore if exists)
-- =========================
INSERT IGNORE INTO categories (name, created_at) VALUES
('Pizza', NOW()),
('Burger', NOW()),
('Sushi', NOW()),
('Desserts', NOW()),
('Beverages', NOW());

-- =========================
-- Insert Products (ignore if exists based on name)
-- =========================
INSERT IGNORE INTO products (name, description, price, image, status, category_id, created_at) VALUES
-- Pizza
('Margherita Pizza', 'Classic pizza with tomato sauce and mozzarella cheese', 299.00, '/images/uploads/margherita.jpg', 'available', 1, NOW()),
('Pepperoni Pizza', 'Pizza topped with pepperoni and cheese', 399.00, '/images/uploads/pepperoni.jpg', 'available', 1, NOW()),
('Veggie Pizza', 'Loaded with fresh vegetables and cheese', 349.00, '/images/uploads/veggie_pizza.jpg', 'available', 1, NOW()),
-- Burger
('Classic Burger', 'Beef patty with lettuce, tomato and cheese', 199.00, '/images/uploads/classic_burger.jpg', 'available', 2, NOW()),
('Chicken Burger', 'Grilled chicken burger with special sauce', 219.00, '/images/uploads/chicken_burger.jpg', 'available', 2, NOW()),
('Veggie Burger', 'Vegetable patty burger with fresh veggies', 179.00, '/images/uploads/veggie_burger.jpg', 'available', 2, NOW()),
-- Sushi
('California Roll', 'Crab, avocado and cucumber roll', 349.00, '/images/uploads/california_roll.jpg', 'available', 3, NOW()),
('Salmon Nigiri', 'Fresh salmon over pressed sushi rice', 399.00, '/images/uploads/salmon_nigiri.jpg', 'available', 3, NOW()),
('Vegetable Roll', 'Healthy vegetable sushi roll', 299.00, '/images/uploads/vegetable_roll.jpg', 'available', 3, NOW()),
-- Desserts
('Chocolate Cake', 'Rich chocolate layered cake', 149.00, '/images/uploads/chocolate_cake.jpg', 'available', 4, NOW()),
('Cheesecake', 'Creamy New York style cheesecake', 179.00, '/images/uploads/cheesecake.jpg', 'available', 4, NOW()),
('Ice Cream', 'Vanilla ice cream scoop', 99.00, '/images/uploads/ice_cream.jpg', 'available', 4, NOW()),
-- Beverages
('Cola', 'Refreshing cold drink', 49.00, '/images/uploads/cola.jpg', 'available', 5, NOW()),
('Orange Juice', 'Fresh orange juice', 79.00, '/images/uploads/juice.jpg', 'available', 5, NOW()),
('Mineral Water', 'Mineral water bottle', 20.00, '/images/uploads/water.jpg', 'available', 5, NOW());

-- =========================
-- Insert Admin User (ignore if exists)
-- =========================
INSERT IGNORE INTO users (name, email, password, phone, address, created_at) VALUES
('Administrator', 'admin@fooddelivery.com', 'admin123', '9876543210', 'Admin Office', NOW());

-- =========================
-- Re-enable foreign key checks
-- =========================
SET FOREIGN_KEY_CHECKS = 1;