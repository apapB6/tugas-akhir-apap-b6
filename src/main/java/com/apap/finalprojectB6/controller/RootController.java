package com.apap.finalprojectB6.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RootController {
    @RequestMapping("/backend")
    private String home() {
        return "check";
    }
}