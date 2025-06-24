package practice.asanxidmet.authentication.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import practice.asanxidmet.authentication.dto.request.AuthRequest;
import practice.asanxidmet.authentication.dto.request.LogoutRequest;
import practice.asanxidmet.authentication.dto.request.RegisterRequest;
import practice.asanxidmet.authentication.dto.response.AuthResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);

    void logout(LogoutRequest request);
    AuthResponse refreshAuthToken(HttpServletRequest request) throws ServletException, IOException;
}
