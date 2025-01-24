package com.training.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayHomePage(Model model) {
        String message = "Mon message";
        model.addAttribute("messageKey", message);
        return "home.html";
    }


}
