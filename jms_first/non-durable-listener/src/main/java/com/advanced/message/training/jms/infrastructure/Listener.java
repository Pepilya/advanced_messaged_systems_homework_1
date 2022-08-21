package com.advanced.message.training.jms.infrastructure;

import com.advanced.message.training.jms.application.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {

    @JmsListener(destination = "test.queue")
    public void processEvent(User user) {
        log.info("Register user with name == {}", user.getFirstName());
    }

}
