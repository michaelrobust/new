package com.example.restaurant.service;

import com.example.restaurant.model.Order;
import com.example.restaurant.model.MenuItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private Map<Long, List<Order>> userOrders = new HashMap<>();

    public String placeOrder(Order order) {
        userOrders.computeIfAbsent(order.getUserId(), k -> new ArrayList<>()).add(order);
        return "Order placed successfully";
    }

    public List<Order> getUserOrders(Long userId) {
        return userOrders.getOrDefault(userId, new ArrayList<>());
    }
}
