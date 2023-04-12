package com.example.share.controllers;

import com.example.share.requests.users.AuthorizationRequest;
import com.example.share.requests.users.RegistrationRequest;
import com.example.share.responses.users.AuthorizationResponse;
import com.example.share.responses.users.RegistrationResponse;
import com.example.share.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authorization")
    public ResponseEntity<AuthorizationResponse> auth(@Valid @RequestBody AuthorizationRequest data){
        return ResponseEntity.ok(userService.authorizationUser(data));
    }

    @PostMapping("/registration")
    public ResponseEntity<RegistrationResponse> registration(@Valid @RequestBody RegistrationRequest data){
        return ResponseEntity.status(201).body(userService.registrationUser(data));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("authorization") String token){
        return ResponseEntity.ok(Map.of("success", userService.logoutUser(token)));
    }
}
