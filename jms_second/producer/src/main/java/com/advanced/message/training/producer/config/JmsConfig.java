package com.advanced.message.training.producer.config;

import com.advanced.message.training.producer.application.service.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public MessageConverter messageConverter() {
        Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
        typeIdMappings.put("_type", Order.class);

        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName("_type");
        messageConverter.setTypeIdMappings(typeIdMappings);
        messageConverter.setObjectMapper(new ObjectMapper());
        return messageConverter;

    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(
            ConnectionFactory connectionFactory,
            MessageConverter messageConverter,
            DefaultJmsListenerContainerFactoryConfigurer configurer
    ) {

        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setReceiveTimeout(1000L);
        containerFactory.setMessageConverter(messageConverter);
        containerFactory.setSessionTransacted(true);
        configurer.configure(containerFactory, connectionFactory);
        return containerFactory;
    }

}
