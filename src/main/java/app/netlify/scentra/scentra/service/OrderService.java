package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    Order updateOrder(Long orderId, Order order);
    void deleteOrder(Long orderId);
    List<Order> getAllOrders();
}
