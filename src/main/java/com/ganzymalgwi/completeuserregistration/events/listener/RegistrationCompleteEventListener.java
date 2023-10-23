package com.ganzymalgwi.completeuserregistration.events.listener;

import com.ganzymalgwi.completeuserregistration.events.RegistrationCompleteEvent;
import com.ganzymalgwi.completeuserregistration.user.User;
import com.ganzymalgwi.completeuserregistration.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener
        implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User theUser = event.getUser();
        String verificationToken = UUID.randomUUID().toString();
        userService.saveUserVerificationToken(theUser, verificationToken);
        String url = event.getApplicationUrl()+"/register/verifyEmail?token=" +verificationToken;
        log.info("CLick the link to verify your registration : {}", url);

    }
}
