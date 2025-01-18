package com.social.flow.lendo.controller;

import com.social.flow.lendo.config.JwtUtil;
import com.social.flow.lendo.config.UserDetailService;
import com.social.flow.lendo.dto.AuthDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api/user")
@RequiredArgsConstructor
public class AuthController {
    @NonNull
    private final AuthenticationManager authenticationManager;
    @NonNull
    private final JwtUtil jwtTokenUtil;
    @NonNull
    private final UserDetailService userDetailsService;

    @PostMapping
    public ResponseEntity<String> createAuthenticationToken(@RequestBody final AuthDto user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.username(), user.password()));

        return ResponseEntity.ok().body(jwtTokenUtil.generateToken(user.username()));
    }

}
