package com.advanced.message.training.producer.application.api;

import com.advanced.message.training.producer.application.service.OrderService;
import com.advanced.message.training.producer.application.service.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Order placeOrder(@RequestBody Order order) {
        return service.confirmOrder(order);
    }

}
