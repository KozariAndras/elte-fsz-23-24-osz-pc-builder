package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.DTOs.FilterDTO;
import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.service.PCComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @Autowired
    private PCComponentService pcComponentService;

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @ModelAttribute("brands")
    public List<String> getBrands() {
        return pcComponentService.findDistinctBrands();
    }

    @ModelAttribute("filter")
    public FilterDTO getFilter(){
        return new FilterDTO();
    }

}
