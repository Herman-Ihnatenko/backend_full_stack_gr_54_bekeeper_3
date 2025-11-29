package de.ait.training.repository;

import de.ait.training.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRep extends JpaRepository<Room, Long> {
    Optional<Room> findById(Long id);
}
