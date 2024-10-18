package app.netlify.scentra.scentra.controller;

import app.netlify.scentra.scentra.model.Product;
import app.netlify.scentra.scentra.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/")
public class MainController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping("/")
    public String index(Model model) {
//        List<Product> featuredProducts = productServiceImp.featuredProducts("yes");
        List<Product> featuredProducts = productServiceImp.getAllProducts().subList(0,3);
        model.addAttribute("featuredProducts", featuredProducts);
        return "index";  // Return the "index.html" or "index" template.
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        List<Product> products = productServiceImp.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("fariin", "Hello World");
        return "shop";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
//        List<Product> products = productServiceImp.getAllProducts();
//        model.addAttribute("products", products);
//        model.addAttribute("fariin", "Hello World");
        return "cart";
    }
    @GetMapping("/contactus")
    public String contactus(Model model) {
        return "contactus";
    }
}
