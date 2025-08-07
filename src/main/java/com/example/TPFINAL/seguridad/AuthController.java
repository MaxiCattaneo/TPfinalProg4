package com.example.TPFINAL.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
//recibe ususario y contra y verifica que sean correctas
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest authRequest) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (auth.isAuthenticated()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
            String role = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElse("USER");
    String token = jwtUtil.generateToken(userDetails.getUsername(), role);
            Map<String, String> tokenMap = Collections.singletonMap("token", token);
            return ResponseEntity.ok(tokenMap);
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
