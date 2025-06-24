package practice.asanxidmet.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
