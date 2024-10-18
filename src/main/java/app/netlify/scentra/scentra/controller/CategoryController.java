package app.netlify.scentra.scentra.controller;

import app.netlify.scentra.scentra.model.Category;
import app.netlify.scentra.scentra.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
//    @Autowired
//    private CategoryService categoryService;
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    // show list of all categories / default GetMapping of the controller
    @GetMapping
    public String showCategories(Model model) {
        List<Category> categories  = categoryServiceImp.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin/categories";
    }
    // new category
    @GetMapping("/new_category")
    public String showNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category_form";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        if(category.getId() != null){
            categoryServiceImp.updateCategory(category.getId(), category);
        }else {
            categoryServiceImp.createCategory(category);
        }
//        return "redirect:/";
         return "redirect:/admin/categories";
    }

    @GetMapping("/edit_category/{id}")
    public String showEditCategoryForm(@PathVariable Long id, Model model) {
        Category category = categoryServiceImp.getCategoryById(id);
        model.addAttribute("category", category);
        return "admin/category_form";
    }

    @GetMapping("/delete_category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryServiceImp.deleteCategory(id);
        return "redirect:/admin/categories";
    }




















//    @GetMapping
//    public List<Category> getAllCategories() {
//        return categoryService.getAllCategories();
//    }
//
//    @PostMapping
//    public Category createCategory(@RequestBody Category category) {
//        return categoryService.createCategory(category);
//    }

}
