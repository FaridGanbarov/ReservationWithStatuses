package practice.asanxidmet.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import practice.asanxidmet.enums.PersonType;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ReservationRequest {
    @NotNull(message = "Date is required")
    @Future(message = "Date must be in the future")
    LocalDate date;

    @NotNull(message = "Time is required")
    LocalTime time;

    @NotNull(message = "Person type is required")
    PersonType personType;
}
