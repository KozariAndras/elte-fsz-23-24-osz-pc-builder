package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.DTOs.UserDto;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.exception.UserAlreadyExistException;
import elte.project.pcbuilder.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);

        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerUser(
            @ModelAttribute("user") @Valid UserDto userDto,
            HttpServletRequest request,
            Errors errors) {

        ModelAndView mav = new ModelAndView();

        try{
            User registered = userService.registerNewUser(userDto);
        }catch (UserAlreadyExistException uaeException){
            mav.addObject("message", "This username already exists, please try a different one. ");
            return mav;
        }
        mav.setViewName("successRegister");
        mav.addObject("user", userDto);
        return mav;

    }
}