package com.sistek.sos.analysis_dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // spring mvc controller, http request to view
public class IndexController {
    @GetMapping("/") // GET request, triggered when page loads or user refreshes
    public String examplePage(Model model) { // you can reach here on thymeleaf with ${}
        model.addAttribute("message", "Welcome to Analysis Dashboard");
        return "index"; // display it on index.html
    }
}