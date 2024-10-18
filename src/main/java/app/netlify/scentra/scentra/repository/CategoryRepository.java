package app.netlify.scentra.scentra.repository;

import app.netlify.scentra.scentra.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
