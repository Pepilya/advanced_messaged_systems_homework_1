package com.advanced.message.training.producer.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.MessagePostProcessor;

import javax.jms.JMSException;
import javax.jms.Message;

@RequiredArgsConstructor
public class CorrelationIdPostProcessor implements MessagePostProcessor {

    private final String correlationId;

    @Override
    public Message postProcessMessage(Message message) throws JMSException {
        message.setJMSMessageID(correlationId);
        return message;
    }
}
