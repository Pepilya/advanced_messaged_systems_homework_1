package com.advanced.message.training.producer.application.service;

import com.advanced.message.training.producer.application.service.model.User;
import com.advanced.message.training.producer.infrastructure.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationService {

    private final ConcurrentHashMap<String, User> map = new ConcurrentHashMap<>();

    private final Producer producer;

    public void registerUser(User user) {
        map.put(user.getUserId(), user);
        producer.publishEvent(user);
    }

}
