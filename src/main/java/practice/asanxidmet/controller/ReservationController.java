package practice.asanxidmet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import practice.asanxidmet.authentication.model.CustomUserDetails;
import practice.asanxidmet.dto.request.ReservationRequest;
import practice.asanxidmet.dto.response.ReservationResponse;
import practice.asanxidmet.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody ReservationRequest request
    ) {
        String userEmail = userDetails.getUsername(); // assuming username is email
        return ResponseEntity.ok(reservationService.createReservation(userEmail, request));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

}
