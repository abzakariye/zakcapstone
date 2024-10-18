package app.netlify.scentra.scentra.controller;

import app.netlify.scentra.scentra.model.Category;
import app.netlify.scentra.scentra.model.Order;
import app.netlify.scentra.scentra.service.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class OrdersController {
    @Autowired
    private OrderServiceImp orderServiceImp;

    @GetMapping
    public String showCategories(Model model) {
        List<Order> orders  = orderServiceImp.getAllOrders();
        model.addAttribute("categories", orders);
        return "admin/orders";
    }
}
