package de.ait.training.repository;

import de.ait.training.model.SportUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SportUserRepository extends JpaRepository<SportUser, Long> {

    Optional<SportUser> findByUsername(String username);

}
