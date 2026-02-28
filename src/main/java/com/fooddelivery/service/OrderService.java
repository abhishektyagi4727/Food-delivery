package com.fooddelivery.service;

import com.fooddelivery.entity.*;
import com.fooddelivery.model.CartItem;
import com.fooddelivery.repository.OrderRepository;
import com.fooddelivery.repository.OrderItemRepository;
import com.fooddelivery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Transactional
    public Order createOrder(User user, String deliveryAddress, String paymentMethod, 
                            List<CartItem> cartItems, BigDecimal total) {
        
        // Create order
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(total);
        order.setPaymentMethod(paymentMethod);
        order.setDeliveryAddress(deliveryAddress);
        order.setStatus(OrderStatus.pending);
        order.setPaymentStatus(PaymentStatus.pending);
        
        // Save order first
        order = orderRepository.save(order);
        
        // Create and save order items
        for (CartItem cartItem : cartItems) {
            Product product = productRepository.findById(cartItem.getProductId()).orElse(null);
            if (product != null) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setProduct(product);
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setPrice(product.getPrice());
                
                orderItemRepository.save(orderItem);
            }
        }
        
        return order;
    }
    
    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUserOrderByCreatedAtDesc(user);
    }
    
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    
    public List<OrderItem> getOrderItems(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
    
    @Transactional
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
    
    @Transactional
    public Order updatePaymentStatus(Long orderId, PaymentStatus paymentStatus) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setPaymentStatus(paymentStatus);
            return orderRepository.save(order);
        }
        return null;
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}