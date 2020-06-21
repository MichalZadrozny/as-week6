package pl.michalzadrozny.asweek6.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class EmailAspectService {

    @Value("${admin.mail}")
    private String email;
    private EmailService emailService;

    @Autowired
    public EmailAspectService(EmailService emailService) {
        this.emailService = emailService;
    }

    @AfterReturning(value = "@annotation(EmailAspect)", returning = "returnValue")
    private void sendMailAdvice(JoinPoint joinPoint, ResponseEntity returnValue) {
        log.info(joinPoint.toShortString());
        if (returnValue.getStatusCodeValue() == 201) {
            log.info("Sending an email");
            emailService.sendEmail(email, "New Movie has been added", "New Movie has been added to list");
        }
    }
}
