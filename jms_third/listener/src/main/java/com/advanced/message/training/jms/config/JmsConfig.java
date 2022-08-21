package com.advanced.message.training.jms.config;

import com.advanced.message.training.jms.application.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsConfig {

    @Value("${spring.activemq.listener.client-id}")
    private String clientId;

    @Bean
    public MessageConverter messageConverter() {
        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("_type", User.class);

        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName("_type");
        messageConverter.setTypeIdMappings(typeIdMappings);
        return messageConverter;

    }

    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory(CachingConnectionFactory connectionFactory, MessageConverter converter) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setMessageConverter(converter);
        containerFactory.setConcurrency("3-5");
        return containerFactory;
    }

}
