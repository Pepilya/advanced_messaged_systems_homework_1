package com.advanced.message.training.jms.infrastructure;

import com.advanced.message.training.jms.application.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {

    private static final Integer MAX_PRODUCT_AMOUNT = 1000;

    @JmsListener(destination = "order.request")
    @SendTo("order.response")
    public Message<Order> processOrder(Order order) {
        log.info("Register user with name == {}", order.getOrderId());
        if (order.getAmount() > MAX_PRODUCT_AMOUNT) {
            order.setStatus(Order.Status.DECLINED);
            return MessageBuilder.withPayload(order).build();
        }
        order.setStatus(Order.Status.APPROVED);
        return MessageBuilder
                .withPayload(order)
                .build();
    }

}
