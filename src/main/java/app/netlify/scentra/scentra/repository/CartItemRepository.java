package app.netlify.scentra.scentra.repository;

import app.netlify.scentra.scentra.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
