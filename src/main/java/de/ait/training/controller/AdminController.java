package de.ait.training.controller;

import de.ait.training.model.Room;
import de.ait.training.model.SportUser;
import de.ait.training.model.User;
import de.ait.training.repository.RoomRep;
import de.ait.training.repository.SportUserRepository;
import de.ait.training.repository.UserRep;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    private final SportUserRepository userRepository;
    private final RoomRep roomRepository;
    private final UserRep userRep;

    public AdminController(SportUserRepository userRepository, RoomRep roomRepository, UserRep userRep) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.userRep = userRep;
    }

    @GetMapping("/api/admin/sport-users")
    public List<SportUser> getAllSportUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/api/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/api/users")
    public List<User> getAllRegularUsers() {
        return userRep.findAll();
    }
}
