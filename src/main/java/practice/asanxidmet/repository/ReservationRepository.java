package practice.asanxidmet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.asanxidmet.entity.Reservation;
import practice.asanxidmet.entity.User;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByDateAndTime(LocalDate date, LocalTime time);
    boolean existsByUserAndDate(User user, LocalDate date);

}
