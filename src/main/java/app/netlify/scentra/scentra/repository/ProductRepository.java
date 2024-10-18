package app.netlify.scentra.scentra.repository;

import app.netlify.scentra.scentra.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findAllBy(String isFeatured);
}
