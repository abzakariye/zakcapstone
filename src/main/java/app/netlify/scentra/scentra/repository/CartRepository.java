package app.netlify.scentra.scentra.repository;

import app.netlify.scentra.scentra.model.Cart;
import app.netlify.scentra.scentra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
