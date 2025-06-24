package practice.asanxidmet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user-email")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Email
    @NotEmpty
    @Column(nullable = false, unique = true)
    String email;

    @Builder.Default
    private boolean verified = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime updatedAt;
}
