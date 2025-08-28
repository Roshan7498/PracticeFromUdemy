package com.projects.demo.controller;
import com.projects.demo.*;
import com.projects.demo.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OAuth2Controller {

    @Autowired
    private JWTService jwtService; // your existing service for generating tokens

    @GetMapping("/oauth2/success")
    public ResponseEntity<?> success(Authentication authentication) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");

        // Optionally save user in DB if not exists
        // userRepository.findOrCreateByEmail(email);

        String jwt = jwtService.generateToken(email);
        return ResponseEntity.ok(Map.of("token", jwt));

    }
}
