package pl.michalzadrozny.asweek6.service;

public interface EmailService {
    void sendEmail(String to, String subject, String content);
}