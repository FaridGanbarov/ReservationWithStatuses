package practice.asanxidmet.authentication.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practice.asanxidmet.authentication.dto.request.AuthRequest;
import practice.asanxidmet.authentication.dto.request.LogoutRequest;
import practice.asanxidmet.authentication.dto.request.RegisterRequest;
import practice.asanxidmet.authentication.dto.response.AuthResponse;
import practice.asanxidmet.authentication.service.impl.AuthenticationServiceImpl;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
@Validated
public class AuthenticationController {
    private final AuthenticationServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@Valid @RequestBody AuthRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshAuthToken(HttpServletRequest request) throws IOException {
        AuthResponse authResponse = service.refreshAuthToken(request);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody LogoutRequest request) {
        service.logout(request);
        return ResponseEntity.ok("Logged out successfully");
    }
}
