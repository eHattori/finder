package com.hattori.finder.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WelcomeController
 */
@RestController
@RequestMapping("finder")
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}