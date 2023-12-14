package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("cart")
    public String cart(Model model){
        List<PCComponent> cartItems = cartService.getPcComponents();
        model.addAttribute("cartItems",cartItems);

        return "cart";
    }

}
