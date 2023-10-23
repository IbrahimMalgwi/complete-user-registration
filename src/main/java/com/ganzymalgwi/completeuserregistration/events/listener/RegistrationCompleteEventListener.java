package com.ganzymalgwi.completeuserregistration.events.listener;

import com.ganzymalgwi.completeuserregistration.events.RegistrationCompleteEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener
        implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

    }
}
