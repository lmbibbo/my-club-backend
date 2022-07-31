package com.lmbibbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLogin() {
        System.out.println("getLogin ...");
        return "login";
    }

    //@PostMapping("login")
    public String postLogin() {
        System.out.println("postLogin ...");
        return "login";
    }
    
}
