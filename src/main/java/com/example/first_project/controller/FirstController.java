package com.example.first_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    public String answer;

    @GetMapping("/hi")
    public String greetings(Model model){
        model.addAttribute("username","wujun");
        return "greetings";
    }

    @GetMapping("/bye")
    public String bye(Model model){
        model.addAttribute("username","wujun");
        return "bye";
    }

}
