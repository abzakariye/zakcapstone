package app.netlify.scentra.scentra.controller;

import app.netlify.scentra.scentra.model.Cart;
import app.netlify.scentra.scentra.model.User;
import app.netlify.scentra.scentra.repository.UserRepository;
import app.netlify.scentra.scentra.service.CartServiceImp;
import app.netlify.scentra.scentra.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class CartController {
    @Autowired
    private final UserServiceImp userServiceImp;

    @Autowired
    private CartServiceImp cartServiceImp;
    @Autowired
    private UserRepository userRepository;

    public CartController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("/cart/addToCart")
    public String addToCart(@RequestParam Long productId, Principal principal)  { // , Principal principal
        // User user = userServiceImp.ge(principal.getName());
        User user = userRepository.findByEmail(principal.getName());

//        Cart cart = user.getCart();
//
//        Cart cart = cartServiceImp.ge(user);
//        Product product = productService.findById(productId);
//
//        int quantity = 1; // Default quantity
//
//        cartService.addCartItem(cart, product, quantity);
        return "redirect:/cart";
    }
}
