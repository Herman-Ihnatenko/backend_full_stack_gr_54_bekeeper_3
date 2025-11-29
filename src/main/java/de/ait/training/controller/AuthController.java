package de.ait.training.controller;

import de.ait.training.auth.JwtResponse;
import de.ait.training.auth.LoginRequest;
import de.ait.training.security.JwtService;
import de.ait.training.service.SportUserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final SportUserDetailService userDetailService;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, SportUserDetailService userDetailService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authRequest =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authResult = authenticationManager.authenticate(authRequest);

        UserDetails userDetails = userDetailService.loadUserByUsername(loginRequest.getUsername());

        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }
}
