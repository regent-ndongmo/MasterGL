package com.projetGL.refactoring.authentification.controllers;

import com.projetGL.refactoring.authentification.Beans.User;
import com.projetGL.refactoring.authentification.models.LoginRequest;
import com.projetGL.refactoring.authentification.models.LoginResponse;
import com.projetGL.refactoring.authentification.models.RegisterRequest;
import com.projetGL.refactoring.authentification.regentJwt.services.AuthenticationService;
import com.projetGL.refactoring.authentification.regentJwt.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
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

}
