package de.ait.training.controller;

import de.ait.training.model.SportUser;
import de.ait.training.repository.SportUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    private final SportUserRepository userRepository;

    public AdminController(SportUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/admin/users")
    public List<SportUser> getAllUsers() {
        return userRepository.findAll();
    }
}
