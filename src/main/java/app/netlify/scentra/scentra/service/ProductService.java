package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long productId,Product product);
    void deleteProduct(Long productId);
    Product getProductById(Long productId);
    List<Product> getAllProducts();
}
