package com.geekbrains.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Hello everybody!");
        return "index";
    }
}
