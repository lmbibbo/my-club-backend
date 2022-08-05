package com.lmbibbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value= "/", produces = "application/json")
public class TemplateController {
    
    @CrossOrigin(origins="*")
    @GetMapping("login")
    public String getLogin() {
        System.out.println("getLogin ...");
        return "login";
    }

    @GetMapping("courses")
    public String getCourses() {
        return "courses";
    }
}


