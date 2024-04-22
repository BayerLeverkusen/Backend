package com.example.eventorganizatorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class controller {
    @PostMapping ("/blea")
    public String register(

    ) {
        String bleja;
        bleja = "eeee";
        System.out.println("message");
        return bleja;
    }
}
