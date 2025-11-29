package de.ait.training.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sport_users")
@NoArgsConstructor
@Data
public class SportUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;


    private boolean enabled = true;

    public SportUser(String username, String password, String role, boolean enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }
}
