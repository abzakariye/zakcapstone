package app.netlify.scentra.scentra.repository;

import app.netlify.scentra.scentra.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
