package com.advanced.message.training.producer.infrastructure;

import com.advanced.message.training.producer.application.service.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

    @Value("${spring.jms.template.request-destination}")
    private String requestDestination;

    @Value("${spring.jms.template.response-destination}")
    private String responseDestination;

    private final JmsTemplate jmsTemplate;

    public Order confirmOrder(Order order) {
        jmsTemplate.convertAndSend(requestDestination, order);
        return (Order) jmsTemplate.receiveAndConvert(responseDestination);
    }

}
