package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.Order;
import app.netlify.scentra.scentra.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order updateOrder(Long orderId, Order updateOrder) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderDate(updateOrder.getOrderDate());
        order.setStatus(updateOrder.getStatus());
        order.setTotalAmount(updateOrder.getTotalAmount());
        order.setUser(updateOrder.getUser());
        order.setOrderItems(updateOrder.getOrderItems());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
