package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderHistoryController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orderHistory")
    public String orderHistoryGet(HttpServletRequest request, Model model){
        User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
        if(loggedInUser != null){
            List<Order> orders = orderService.getOrdersByUser(loggedInUser);
            model.addAttribute("orders",orders);
            return "orderHistory";
        } else {
            return "login";
        }
    }
}
