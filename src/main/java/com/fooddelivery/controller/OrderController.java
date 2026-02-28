package com.fooddelivery.controller;

import com.fooddelivery.entity.Order;
import com.fooddelivery.entity.User;
import com.fooddelivery.model.CartItem;
import com.fooddelivery.service.CartService;
import com.fooddelivery.service.OrderService;
import com.fooddelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/checkout")
    public String showCheckout(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            return "redirect:/cart";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());

        model.addAttribute("user", user);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", cartService.getTotal());
        return "checkout";
    }

    @PostMapping("/place")
    public String placeOrder(@RequestParam("delivery_address") String deliveryAddress,
                             @RequestParam("payment_method") String paymentMethod) {
        
        List<CartItem> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            return "redirect:/cart";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());

        BigDecimal total = cartService.getTotal();

        Order order = orderService.createOrder(user, deliveryAddress, paymentMethod, cartItems, total);
        
        // Clear the cart
        cartService.clearCart();

        return "redirect:/order/success/" + order.getId();
    }

    @GetMapping("/success/{orderId}")
    public String orderSuccess(@PathVariable("orderId") Long orderId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());

        Order order = orderService.getOrderById(orderId);
        if (order == null || !order.getUser().getId().equals(user.getId())) {
            return "redirect:/";
        }

        model.addAttribute("order", order);
        return "order-success";
    }

    @GetMapping("/my-orders")
    public String myOrders(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());

        List<Order> orders = orderService.getUserOrders(user);
        model.addAttribute("orders", orders);
        return "orders";
    }
}