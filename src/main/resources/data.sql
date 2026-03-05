-- =========================
-- PostgreSQL Data Initialization
-- =========================

-- Insert Categories (skip if exists)
INSERT INTO categories (name, created_at)
SELECT 'Pizza', NOW()
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Pizza');

INSERT INTO categories (name, created_at)
SELECT 'Burger', NOW()
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Burger');

INSERT INTO categories (name, created_at)
SELECT 'Sushi', NOW()
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Sushi');

INSERT INTO categories (name, created_at)
SELECT 'Desserts', NOW()
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Desserts');

INSERT INTO categories (name, created_at)
SELECT 'Beverages', NOW()
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Beverages');

-- =========================
-- Insert Products (skip if exists based on name)
-- =========================
-- Pizzas (category_id = 1)
INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Margherita Pizza', 'Classic pizza with tomato sauce and mozzarella cheese', 299.00, '/images/uploads/margherita.jpg', 'available', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Margherita Pizza');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Pepperoni Pizza', 'Pizza topped with pepperoni and cheese', 399.00, '/images/uploads/pepperoni.jpg', 'available', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Pepperoni Pizza');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Veggie Pizza', 'Loaded with fresh vegetables and cheese', 349.00, '/images/uploads/veggie_pizza.jpg', 'available', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Veggie Pizza');

-- Burgers (category_id = 2)
INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Classic Burger', 'Beef patty with lettuce, tomato and cheese', 199.00, '/images/uploads/classic_burger.jpg', 'available', 2, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Classic Burger');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Chicken Burger', 'Grilled chicken burger with special sauce', 219.00, '/images/uploads/chicken_burger.jpg', 'available', 2, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Chicken Burger');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Veggie Burger', 'Vegetable patty burger with fresh veggies', 179.00, '/images/uploads/veggie_burger.jpg', 'available', 2, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Veggie Burger');

-- Sushi (category_id = 3)
INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'California Roll', 'Crab, avocado and cucumber roll', 349.00, '/images/uploads/california_roll.jpg', 'available', 3, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'California Roll');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Salmon Nigiri', 'Fresh salmon over pressed sushi rice', 399.00, '/images/uploads/salmon_nigiri.jpg', 'available', 3, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Salmon Nigiri');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Vegetable Roll', 'Healthy vegetable sushi roll', 299.00, '/images/uploads/vegetable_roll.jpg', 'available', 3, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Vegetable Roll');

-- Desserts (category_id = 4)
INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Chocolate Cake', 'Rich chocolate layered cake', 149.00, '/images/uploads/chocolate_cake.jpg', 'available', 4, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Chocolate Cake');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Cheesecake', 'Creamy New York style cheesecake', 179.00, '/images/uploads/cheesecake.jpg', 'available', 4, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Cheesecake');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Ice Cream', 'Vanilla ice cream scoop', 99.00, '/images/uploads/ice_cream.jpg', 'available', 4, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Ice Cream');

-- Beverages (category_id = 5)
INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Cola', 'Refreshing cold drink', 49.00, '/images/uploads/cola.jpg', 'available', 5, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Cola');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Orange Juice', 'Fresh orange juice', 79.00, '/images/uploads/juice.jpg', 'available', 5, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Orange Juice');

INSERT INTO products (name, description, price, image, status, category_id, created_at)
SELECT 'Mineral Water', 'Mineral water bottle', 20.00, '/images/uploads/water.jpg', 'available', 5, NOW()
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Mineral Water');

-- =========================
-- Insert Admin User (skip if exists)
-- =========================
INSERT INTO users (name, email, password, phone, address, created_at)
SELECT 'Administrator', 'admin@fooddelivery.com', 'admin123', '9876543210', 'Admin Office', NOW()
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'admin@fooddelivery.com');