package com.projetGL.refactoring.authentification.regentJwt.services;

import com.projetGL.refactoring.authentification.Beans.Role;
import com.projetGL.refactoring.authentification.Beans.User;
import com.projetGL.refactoring.authentification.Repository.RoleRepository;
import com.projetGL.refactoring.authentification.Repository.UserRepository;
import com.projetGL.refactoring.authentification.models.LoginRequest;
import com.projetGL.refactoring.authentification.models.RegisterRequest;
import com.projetGL.refactoring.authentification.regentJwt.exceptions.CustomAuthenticationException;
import com.projetGL.refactoring.authentification.regentJwt.exceptions.UserNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterRequest input) {
        Long defauldRoleId;
        if (input.getRole().getId() != null) {
            defauldRoleId = input.getRole().getId();
        }
        else {
            defauldRoleId = 1L;
        }

        Optional<Role> role = roleRepository.findByIdOrNull(defauldRoleId);
        if (role.isPresent()) {
            input.setRole(role.get());
        }
        User user = new User(input);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginRequest input) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getEmail(),
                            input.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new CustomAuthenticationException("Invalid email or password", e);
        }

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found with email " + input.getEmail()));
    }
}
