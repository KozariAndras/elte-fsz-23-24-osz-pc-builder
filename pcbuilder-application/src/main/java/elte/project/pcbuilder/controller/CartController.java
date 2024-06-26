package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.DTOs.CheckoutDTO;
import elte.project.pcbuilder.domain.DTOs.PCComponentDTO;
import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.service.AuthenticationService;
import elte.project.pcbuilder.service.CartService;
import elte.project.pcbuilder.service.OrderService;
import elte.project.pcbuilder.service.PCComponentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private PCComponentService pcComponentService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/cart")
    public String cart(Model model, @ModelAttribute("cart") Cart cart){

        Map<PCComponent, Integer> map = new Hashtable<>();
        for (PCComponent comp: cart.getPcComponents()){
            if (!map.containsKey(comp)){
                map.put(comp,1);
            }
            else{
                map.put(comp,map.get(comp) + 1);
            }
        }

        CheckoutDTO data = new CheckoutDTO(cartService.calculateTotalPrice(cart.getPcComponents()));
        for (PCComponent comp: map.keySet()) {
            data.getItems().add(new PCComponentDTO(comp.getId(),comp.getName(),comp.getBrand(),comp.getPrice(),map.get(comp)));
        }

        model.addAttribute("Data", data);
        return "cart";
    }

    @PostMapping("/addToCart")
    public String addToCart(@ModelAttribute("cart") Cart cart, @RequestParam("componentId") int id, HttpServletRequest request,Model model){
        String referer = request.getHeader("referer");
        PCComponent requestedComponent = pcComponentService.findById(id);
        cart.getPcComponents().add(requestedComponent);
        if(referer.endsWith("searchFilter")){
            return "redirect:/";
        }
        return "redirect:" + referer;
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(@ModelAttribute("cart") Cart cart, @RequestParam("componentId") int id, HttpServletRequest request){
        String referer = request.getHeader("referer");
        cart.getPcComponents().stream().filter(comp -> comp.getId() == id).findFirst().ifPresent(cart.getPcComponents()::remove);
        return "redirect:" + referer;
    }

    @PostMapping("/removeAllFromCart")
    public String removeAllFromCart(@ModelAttribute("cart") Cart cart, @RequestParam("componentId") int id, HttpServletRequest request){
        String referer = request.getHeader("referer");
        cart.getPcComponents().removeIf(comp -> comp.getId() == id);
        return "redirect:" + referer;
    }

    @PostMapping("/checkout")
    public ModelAndView checkout(@ModelAttribute("cart") Cart cart, HttpServletRequest request, RedirectAttributes rv){
        User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
        if (loggedInUser != null){
            orderService.create(cart.getPcComponents(),loggedInUser);
            cart.getPcComponents().clear();
            rv.addFlashAttribute("successMessage","Items were successfully ordered!");
            return new ModelAndView(new RedirectView("/cart"));
        }
        else{
            return new ModelAndView(new RedirectView("/login"));
        }
    }

}
