package practice.asanxidmet.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.asanxidmet.entity.UserEmail;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<UserEmail, Long> {
    @Transactional
    void deleteByEmail(String email);
    Optional<UserEmail> findByEmail(String email);
}
