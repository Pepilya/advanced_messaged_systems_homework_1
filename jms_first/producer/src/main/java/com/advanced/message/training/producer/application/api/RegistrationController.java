package com.advanced.message.training.producer.application.api;

import com.advanced.message.training.producer.application.service.RegistrationService;
import com.advanced.message.training.producer.application.service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void register(@RequestBody User user) {
        service.registerUser(user);
    }

}
