package elte.project.pcbuilder.controller;

import elte.project.pcbuilder.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
