package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.user.Cart;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultModelAttributeController {
    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }
}
