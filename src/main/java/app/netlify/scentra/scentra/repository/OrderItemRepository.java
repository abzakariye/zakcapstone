package app.netlify.scentra.scentra.repository;

import app.netlify.scentra.scentra.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
