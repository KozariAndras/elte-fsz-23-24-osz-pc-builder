package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.DTOs.UserLoginDto;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.exception.InvalidPasswordException;
import elte.project.pcbuilder.exception.InvalidUserNameException;
import elte.project.pcbuilder.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.InvalidIsolationLevelException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView logInUser(
            @ModelAttribute("user") @Valid UserLoginDto userLoginDto,
            @RequestParam("userId") int id,
            BindingResult bindingResult,
            HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();

        // Validate user input
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.append(error.getDefaultMessage()).append("<br>");
            }
            mav.addObject("message", errorMessages.toString());
            mav.setViewName("login");
            return mav;
        }

        try {
            Optional<User> supposedExistingUser = userService.findByUsername(userLoginDto.getUsername());

            if (supposedExistingUser.isPresent()) {
                User foundUser = supposedExistingUser.get();
                if (userService.validatePassword(foundUser, userLoginDto.getPassword())) {

                    request.getSession().setAttribute("user", supposedExistingUser);
                    mav.setViewName("redirect:/");
                } else {
                    throw new InvalidPasswordException("Invalid Password");
                }
            }
        } catch (InvalidUserNameException | InvalidPasswordException e) {
            mav.addObject("message", e.getMessage());
            mav.setViewName("login");
        } catch (InvalidIsolationLevelException e) {
            mav.setViewName("login");
        }
        return mav;
    }
}
