package com.advanced.message.training.producer.config;

import com.advanced.message.training.producer.application.service.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class JmsConfig {

    @Bean
    public MessageConverter messageConverter() {
        Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
        typeIdMappings.put("_type", User.class);

        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName("_type");
        messageConverter.setTypeIdMappings(typeIdMappings);
        messageConverter.setObjectMapper(new ObjectMapper());
        return messageConverter;

    }

}
