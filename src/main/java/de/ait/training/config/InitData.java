package de.ait.training.config;

import de.ait.training.model.Room;
import de.ait.training.model.SportUser;
import de.ait.training.model.User;
import de.ait.training.repository.SportUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner initCommandLineRunner(SportUserRepository repository,
                                            PasswordEncoder encoder) {
        return args -> {
            if (repository.count() == 0) {
                SportUser sportUser = new SportUser("user", encoder.encode("user123"), "ROLE_USER", true);
                SportUser sportAdmin = new SportUser("admin", encoder.encode("admin123"), "ROLE_ADMIN", true);

                User admin = new User("admin", encoder.encode("admin123"), "ADMIN", true);
                Room room = new Room(1L, "1", 100, true);

                repository.save(sportUser);
                repository.save(sportAdmin);
                repository.save(admin);
                repository.save(room);
            }
        };

    }
}
