package practice.asanxidmet.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.asanxidmet.dto.request.ReservationRequest;
import practice.asanxidmet.dto.response.ReservationResponse;
import practice.asanxidmet.entity.Reservation;
import practice.asanxidmet.entity.User;
import practice.asanxidmet.enums.Exceptions;
import practice.asanxidmet.enums.PersonType;
import practice.asanxidmet.exception.ApplicationException;
import practice.asanxidmet.repository.ReservationRepository;
import practice.asanxidmet.repository.UserRepository;
import practice.asanxidmet.service.EmailService;
import practice.asanxidmet.service.ReservationService;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    @Override
    @Transactional
    public ReservationResponse createReservation(String userEmail, ReservationRequest request) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND));
        boolean alreadyReservedToday = reservationRepository.existsByUserAndDate(user, request.getDate());
        if (alreadyReservedToday) {
            throw new ApplicationException(Exceptions.ALREADY_RESERVED_FOR_TODAY);
        }


        boolean exists = reservationRepository.existsByDateAndTime(request.getDate(), request.getTime());
        if (exists) {
            throw new ApplicationException(Exceptions.TIME_SLOT_TAKEN);
        }


        Reservation reservation = Reservation.builder()
                .date(request.getDate())
                .time(request.getTime())
                .personType(request.getPersonType())
                .user(user)
                .build();

        Reservation saved = reservationRepository.save(reservation);
        emailService.sendReservationNotification(
                user.getEmail(),
                request.getDate().toString(),
                request.getTime().toString(),
                request.getPersonType().name()
        );
        return mapToResponse(saved);
    }

    @Override
    public List<ReservationResponse> getAllReservations() {
        return reservationRepository.findAll().stream()
                .sorted(Comparator
                        .comparing((Reservation r) -> getPriority(r.getPersonType()))
                        .thenComparing(Reservation::getDate)
                        .thenComparing(Reservation::getTime)
                )
                .map(this::mapToResponse)
                .toList();
    }
    private int getPriority(PersonType personType) {
        return switch (personType) {
            case SHEHID_AILESI -> 1;
            case QAZI -> 2;
            case REGULAR -> 3;
        };
    }

    private ReservationResponse mapToResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .date(reservation.getDate())
                .time(reservation.getTime())
                .personType(reservation.getPersonType())
                .userEmail(reservation.getUser().getEmail())
                .build();
    }
}
