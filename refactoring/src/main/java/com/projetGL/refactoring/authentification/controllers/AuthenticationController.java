package com.projetGL.refactoring.authentification.controllers;

import com.projetGL.refactoring.authentification.Beans.User;
import com.projetGL.refactoring.authentification.Repository.UserRepository;
import com.projetGL.refactoring.authentification.models.LoginRequest;
import com.projetGL.refactoring.authentification.models.LoginResponse;
import com.projetGL.refactoring.authentification.models.RegisterRequest;
import com.projetGL.refactoring.authentification.regentJwt.services.AuthenticationService;
import com.projetGL.refactoring.authentification.regentJwt.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User registeredUser = authenticationService.signup(registerRequest);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        long expirationTime = jwtService.getExpirationTime();

        LoginResponse loginResponse = new LoginResponse(jwtToken, expirationTime);

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<User> getUserDetails(@RequestHeader("Authorization") String token) {
        String jwt = token.replace("Bearer ", "");

        String username = jwtService.extractUsername(jwt);

        User user = authenticationService.getUserDetails(username);

        return ResponseEntity.ok(user);
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = authenticationService.allUsers();

        return ResponseEntity.ok(users);
    }

}
