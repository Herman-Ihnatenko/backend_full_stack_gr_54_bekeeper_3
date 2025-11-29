package de.ait.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/api/public/info")
    public String info() {
        return "Sport Hub API, публичная информация.";
    }
}
