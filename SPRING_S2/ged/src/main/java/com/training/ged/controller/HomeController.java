package com.training.ged.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {

    @GetMapping("/")
    public String displayHomePage(Model model) {
        log.info("displaying homePage");
        return "home.html";
    }


}
