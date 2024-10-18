package app.netlify.scentra.scentra.controller;

import app.netlify.scentra.scentra.model.Category;
import app.netlify.scentra.scentra.model.Product;
import app.netlify.scentra.scentra.service.CategoryServiceImp;
import app.netlify.scentra.scentra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ProductService productServiceImp;
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products", productServiceImp.getAllProducts());
        return "admin/products";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryServiceImp.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("message", "Add product details");
        return "admin/pr_form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product,
                              @RequestParam("productImage") MultipartFile imageFile, Model model) {
        try {
            // Check if image file is not empty
            if (!imageFile.isEmpty()) {
                // Save the file to the target directory
                String imageFileName = imageFile.getOriginalFilename();
                String uploadDir = "src/main/resources/static/product-images/";

                // Create directories if they don't exist
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Save the image file
                Path filePath = uploadPath.resolve(imageFileName);
                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Set the product image URL (relative path) to store in the database
                product.setProductImageUrl("/product-images/" + imageFileName);
            }
            // Save the product details to the database
            productServiceImp.createProduct(product);
//            return "redirect:/product/list";
            return "redirect:/admin/products";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("product", new Product());
            model.addAttribute("message", "Add product details");
            model.addAttribute("errorMessage", "Error saving the image. Please try again.");
//            return "product-form";
//            return "redirect:/admin/products";
            return "admin/pr_form";
        }



//        if (!file.isEmpty()) {
//            String fileName = file.getOriginalFilename();
//            String uploadDir = "\\src\\main\\resources\\static\\product-images\\";
//
//            File uploadDirectory = new File(uploadDir);
//            if (!uploadDirectory.exists()) {
//                uploadDirectory.mkdirs();  // Create the directory if it doesn't exist
//            }
//
//            try {
//                // Save file to directory
//                file.transferTo(new File(uploadDir + fileName));
//
//                // Set the file name to the product's image URL field
//                product.setProductImageUrl("/product-images/" + fileName);  // Use relative URL for serving the image
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Handle exception if file upload fails
//            }
//        }
//
//        // Save the product (assuming you have a ProductService or repository to handle saving)
//        productServiceImp.createProduct(product);
//        return "redirect:/admin/products";
    }
    @GetMapping("/edit_product/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productServiceImp.getProductById(id);
        model.addAttribute("product", product);
        List<Category> categories = categoryServiceImp.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("errorMessage", "Error updating the product. Please try again.");
        return "admin/edit_product";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("category") Product product,
                              @RequestParam("imageFile") MultipartFile imageFile,
                              Model model) {
        try {
            // Retrieve the existing product from the database
            Product existingProduct = productServiceImp.getProductById(product.getId());

            // Check if a new image file has been uploaded
            if (!imageFile.isEmpty()) {
                // Get the file name and save the new image file
                String imageFileName = imageFile.getOriginalFilename();
                String uploadDir = "src/main/resources/static/product-images/";

                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Path filePath = uploadPath.resolve(imageFileName);
                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Update product image URL (relative path) with the new file
                product.setProductImageUrl("/product-images/" + imageFileName);

                // Optionally: delete the old image file if desired
                String oldImagePath = uploadDir + existingProduct.getProductImageUrl().substring("/product-images/".length());
                Files.deleteIfExists(Paths.get(oldImagePath));
            } else {
                // If no new image is uploaded, retain the existing image path
                product.setProductImageUrl(existingProduct.getProductImageUrl());
            }

            // Save the updated product details to the database
            productServiceImp.createProduct(product);

            return "redirect:/admin/products";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error updating the product. Please try again.");
            return "edit_product";
        }
    }


    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productServiceImp.deleteProduct(id);
        return "redirect:/admin/products";
    }
}

