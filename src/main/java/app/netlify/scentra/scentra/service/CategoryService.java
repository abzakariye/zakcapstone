package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    Category updateCategory(Long categoryId,Category category);
    void deleteCategory(Long categoryId);
}
