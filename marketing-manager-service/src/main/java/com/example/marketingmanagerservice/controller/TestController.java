package com.example.marketingmanagerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/8052")
public class TestController {

    @PostMapping("/kurac")
    public String register() {
        String nesto = "kurac";
        return nesto;
    }
}