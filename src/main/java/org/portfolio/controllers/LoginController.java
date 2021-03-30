package org.portfolio.controllers;

import org.portfolio.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/login")
    public String login2() {
        return "login";
    }

    @GetMapping(value = "/herps")
    public String herpMainPage() {
        return "herpetology";
    }

    @PostMapping(value = "/logout")
    public String logout() {
        return "login";
    }
}
