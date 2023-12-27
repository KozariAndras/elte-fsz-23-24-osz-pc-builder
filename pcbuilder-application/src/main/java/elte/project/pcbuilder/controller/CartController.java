package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.service.CartService;
import elte.project.pcbuilder.service.PCComponentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private PCComponentService pcComponentService;

    @GetMapping("/cart")
    public String cart(Model model, @ModelAttribute("cart") Cart cart){
        model.addAttribute("cartItems", cart.getPcComponents());

        return "cart";
    }

    @PostMapping("/addToCart")
    public String addToCart(@ModelAttribute("cart") Cart cart, @RequestParam("componentId") int id, HttpServletRequest request){
        String referer = request.getHeader("referer");
        PCComponent requestedComponent = pcComponentService.findById(id);
        cart.getPcComponents().add(requestedComponent);
        return "redirect:" + referer;
    }



}
