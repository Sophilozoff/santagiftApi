package fr.m2i.santagiftapi.controllers;

import fr.m2i.santagiftapi.config.security.JwtResponse;
import fr.m2i.santagiftapi.config.security.JwtUtils;
import fr.m2i.santagiftapi.config.security.MessageResponse;
import fr.m2i.santagiftapi.config.security.UserDetailsImpl;
import fr.m2i.santagiftapi.enums.ERole;
import fr.m2i.santagiftapi.models.Role;
import fr.m2i.santagiftapi.models.User;
import fr.m2i.santagiftapi.repositories.RoleRepository;
import fr.m2i.santagiftapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableWebMvc
@RequestMapping(value = "/api/auth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        System.out.println(user.getUsername()+user.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping( "/signup")
    public User saveUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        } else if (userRepository.existsByEmail(user.getEmail())) {
            ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        List<Role> strRoles = user.getRoles();
        List<Role> roles = new ArrayList<>();

        if (strRoles == null) {
            Role childRole = roleRepository.findByName(ERole.ROLE_CHILD)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(childRole);
        } else {
            strRoles.forEach(role -> {
                switch (role.getLibelle()) {
                    case "Enfant":
                        Role childRole = roleRepository.findByName(ERole.ROLE_CHILD)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(childRole);

                        break;
                    case "Père-Noël":
                        Role santaRole = roleRepository.findByName(ERole.ROLE_SANTA)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(santaRole);

                        break;
                    case "Modérateur":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    case "Administrateur":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                }
            });
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
