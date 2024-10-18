package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.Product;
import app.netlify.scentra.scentra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product product =  productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());
        product.setProductImageUrl(updatedProduct.getProductImageUrl());
        product.setIsFeatured(updatedProduct.getIsFeatured());
//        product.setFeatured(updatedProduct.isFeatured());
        product.setCategory(updatedProduct.getCategory());
        product.setCartItems(updatedProduct.getCartItems());
        product.setOrderItems(updatedProduct.getOrderItems());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    public List<Product> featuredProducts(String isFeatured) {
//        return productRepository.findAllBy(isFeatured);
//    }
}
