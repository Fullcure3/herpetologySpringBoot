package org.portfolio.controllers;

import org.portfolio.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping(value = "login")
    public ModelAndView login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            ModelAndView modelAndView) {

        redirectUserToWebpage(username, password, modelAndView);
        return modelAndView;
    }

    private void redirectUserToWebpage(String username, String password, ModelAndView modelAndView) {
        modelAndView.setViewName(loginService.isValidUser(username, password) ? "herpetology" : "login");
    }
}
