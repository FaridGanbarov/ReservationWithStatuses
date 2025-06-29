package practice.asanxidmet.service;

import practice.asanxidmet.dto.request.ReservationRequest;
import practice.asanxidmet.dto.response.ReservationResponse;

import java.util.List;

public interface ReservationService {
    ReservationResponse createReservation(String userEmail, ReservationRequest request);
    List<ReservationResponse> getAllReservations();
}
