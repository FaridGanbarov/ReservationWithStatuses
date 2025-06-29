package practice.asanxidmet.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import practice.asanxidmet.enums.PersonType;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationResponse {
    Long id;
    LocalDate date;
    LocalTime time;
    PersonType personType;
    String userEmail;
}
