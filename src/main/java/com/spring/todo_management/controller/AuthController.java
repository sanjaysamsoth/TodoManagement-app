package com.spring.todo_management.controller;

import com.spring.todo_management.dto.JwtAuthResponse;
import com.spring.todo_management.dto.LoginDto;
import com.spring.todo_management.dto.RegisterDto;
import com.spring.todo_management.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto logindto){
        String token = authService.login(logindto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();

        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse,HttpStatus.OK);
    }
}
