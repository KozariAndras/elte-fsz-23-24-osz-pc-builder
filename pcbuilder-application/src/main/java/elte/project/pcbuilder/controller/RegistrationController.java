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
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
            BindingResult bindingResult,
            Errors errors) {

        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()) {
            // Validation had errors, returning the
                // There are validation errors, handle them
                for (ObjectError error : bindingResult.getAllErrors()) {
                    mav.addObject("message", error.getDefaultMessage());
                }
            //mav.addObject("message", "Password needs to be at least 8 character long");
            mav.setViewName("register");
            return mav;
        }

        if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
            // Passwords do not match
            mav.addObject("message","Passwords do not match" );
            //bindingResult.rejectValue("matchingPassword", "error.user", "Passwords do not match");
            return mav;
        }

        try{
            User registered = userService.registerNewUser(userDto);
        }catch (UserAlreadyExistException uaeException){
            mav.addObject("message", "This username already exists, please try a different one. ");
            return mav;
        }
        mav.setViewName("redirect:/login");
        mav.addObject("user", userDto);


        return mav;

    }
}