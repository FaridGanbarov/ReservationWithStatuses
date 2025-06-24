package practice.asanxidmet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import practice.asanxidmet.enums.PersonType;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reservations")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PersonType personType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
