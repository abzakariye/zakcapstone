package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.OrderItem;
import app.netlify.scentra.scentra.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemServiceImp implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId)
                .orElseThrow(()-> new RuntimeException("OrderItem not found"));
    }

    @Override
    public OrderItem updateOrderItem(Long orderItemId, OrderItem updatedOrderItem) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(()-> new RuntimeException("OrderItem not found"));
        orderItem.setProduct(updatedOrderItem.getProduct());
        orderItem.setQuantity(updatedOrderItem.getQuantity());
        orderItem.setPrice(updatedOrderItem.getPrice());
        orderItem.setOrder(updatedOrderItem.getOrder());
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }
}
