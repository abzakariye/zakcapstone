package app.netlify.scentra.scentra.controller;


import app.netlify.scentra.scentra.model.User;
import app.netlify.scentra.scentra.repository.UserRepository;
import app.netlify.scentra.scentra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/")
//    public String index(Model model) {
//
//        return "index";  // Return the "index.html" or "index" template.
//    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("isAuthenticated()")
    public String adminDashboard(Model model) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("message", "Hello " + user.getFirstName() + " " + user.getLastName());

        return "admin/dashboard";
    }

    @GetMapping("/user/dashboard")
    @PreAuthorize("isAuthenticated()")
    public String userDashboard(Model model) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        model.addAttribute("message", "Hello " + user.getFirstName() + " " + user.getLastName());
        return "user/dashboard";
    }


}
