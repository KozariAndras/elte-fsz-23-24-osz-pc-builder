package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login (Credential credential, Model model)
    {
        User loggedInUser = authenticationService.authenticateUser(credential);

        if(loggedInUser.getId() != 0)
        {
            //Successful authentication!
            model.addAttribute("username", loggedInUser.getCredential().getUsername());
            return "redirect:/";

        }else {
            //authentication failed.
            model.addAttribute("error", "Invalid username or password");
            return  "error";
        }
    }
}


