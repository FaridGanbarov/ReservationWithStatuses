package practice.asanxidmet.service;

import practice.asanxidmet.dto.request.EmailActivationRequest;
import practice.asanxidmet.dto.request.EmailRequest;

public interface EmailService {
    void sendVerificationCode(String email);
    void sendActivationLink(String email);
    void registerEmail(EmailRequest request);
    void activateEmail(EmailActivationRequest request);
    void deleteStoredEmail(String email);
}
