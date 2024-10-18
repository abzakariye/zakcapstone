package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Long orderItemId);
    OrderItem updateOrderItem(Long orderItemId, OrderItem orderItem);
    void deleteOrderItem(Long orderItemId);
    List<OrderItem> getAllOrderItems();
}
