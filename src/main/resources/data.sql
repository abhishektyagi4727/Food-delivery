-- Insert Categories
INSERT INTO categories (name) VALUES 
('Pizza'),
('Burger'),
('Sushi'),
('Desserts'),
('Beverages')
ON CONFLICT (name) DO NOTHING;

-- Insert Products
INSERT INTO products (category_id, name, description, price, image, status) VALUES
-- Pizzas
(1, 'Margherita Pizza', 'Classic pizza with tomato sauce, mozzarella, and fresh basil', 299.00, '/images/pizza/margherita.jpg', 'available'),
(1, 'Pepperoni Pizza', 'Pizza topped with pepperoni and cheese', 399.00, '/images/pizza/pepperoni.jpg', 'available'),
(2, 'Classic Burger', 'Beef patty with lettuce, tomato, and cheese', 199.00, '/images/burger/classic.jpg', 'available'),
(2, 'Chicken Burger', 'Grilled chicken with special sauce', 219.00, '/images/burger/chicken.jpg', 'available'),
(3, 'California Roll', 'Crab, avocado, and cucumber roll', 349.00, '/images/sushi/california.jpg', 'available'),
(4, 'Chocolate Cake', 'Rich chocolate layer cake', 149.00, '/images/desserts/cake.jpg', 'available'),
(5, 'Cola', 'Refreshing cola drink', 49.00, '/images/beverages/cola.jpg', 'available');

-- Insert Admin User
INSERT INTO users (name, email, password, phone, address) VALUES 
('Administrator', 'admin@fooddelivery.com', 'admin123', '9876543210', 'Admin Office, Mumbai')
ON CONFLICT (email) DO NOTHING;