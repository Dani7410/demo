package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorpageController {

    @GetMapping("/adgang-nægtet")
    public String accessDenied() {
        return "/access-denied";
    }
}
