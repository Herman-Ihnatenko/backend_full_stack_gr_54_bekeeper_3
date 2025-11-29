package de.ait.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @GetMapping("/api/sports/matches")
    public List<String> matches() {
        return List.of("Football: Team A vs Team B", "Basketball: Team A vs Team B");
    }

}
