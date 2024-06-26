package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.DTOs.FilterDTO;
import elte.project.pcbuilder.domain.DTOs.UserDto;
import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.service.PCComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import elte.project.pcbuilder.domain.DTOs.UserLoginDto;

import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @ModelAttribute("filter")
    public FilterDTO getFilter(){
        return new FilterDTO();
    }

    @ModelAttribute("user")
    public UserDto getUser() {return new UserDto();}

    @ModelAttribute("loginUser")
    public UserLoginDto getLoginUser() {return new UserLoginDto();}

}
