package com.projetGL.refactoring.authentification.regentJwt.config;

import com.projetGL.refactoring.authentification.Beans.Role;
import com.projetGL.refactoring.authentification.Beans.User;
import com.projetGL.refactoring.authentification.Repository.RoleRepository;
import com.projetGL.refactoring.authentification.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Initialiser les rôles
        if (roleRepository.count() == 0) {
            Role adminRole = new Role("ROLE_ADMIN");
            Role userRole = new Role("ROLE_USER");
            Role guestRole = new Role("ROLE_GUEST");

            roleRepository.save(adminRole);
            roleRepository.save(userRole);
            roleRepository.save(guestRole);
        }

        if (userRepository.count() == 0) {
            Role userRole = roleRepository.findByRoleName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found"));
            User defaultUser = new User("admin@test.com", "admin", "admin", "kit156", "657730825", passwordEncoder.encode("password"), "Dschang", userRole);

            userRepository.save(defaultUser);
        }
    }
}
