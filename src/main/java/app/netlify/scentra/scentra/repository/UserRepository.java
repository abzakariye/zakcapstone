package app.netlify.scentra.scentra.repository;

import app.netlify.scentra.scentra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
