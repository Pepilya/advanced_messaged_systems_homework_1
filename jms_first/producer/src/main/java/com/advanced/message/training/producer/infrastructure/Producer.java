package com.advanced.message.training.producer.infrastructure;

import com.advanced.message.training.producer.application.service.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

    @Value("${spring.jms.template.destination}")
    private String destination;

    private final JmsTemplate jmsTemplate;

    public void publishEvent(User user) {
        jmsTemplate.convertAndSend(destination, user);
    }

}
