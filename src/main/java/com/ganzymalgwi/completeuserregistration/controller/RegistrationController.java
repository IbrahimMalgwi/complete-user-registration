package com.ganzymalgwi.completeuserregistration.controller;

import com.ganzymalgwi.completeuserregistration.events.RegistrationCompleteEvent;
import com.ganzymalgwi.completeuserregistration.registration.RegistrationRequest;
import com.ganzymalgwi.completeuserregistration.user.User;
import com.ganzymalgwi.completeuserregistration.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RegistrationController {

    private final UserServiceImpl userService;
    private final ApplicationEventPublisher publisher;

    @PostMapping("register")
    public String registerUser(RegistrationRequest registrationRequest,
                               final HttpServletRequest request){
        User user = userService.registerUser(registrationRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "Registration successful, please check your email to complete";

    }

    public String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();    }

}
