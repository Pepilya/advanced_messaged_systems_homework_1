package com.advanced.message.training.producer.application.service;

import com.advanced.message.training.producer.application.service.model.Order;
import com.advanced.message.training.producer.infrastructure.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final ConcurrentHashMap<String, Order> map = new ConcurrentHashMap<>();

    private final Producer producer;

    public Order confirmOrder(Order order) {
        map.put(order.getOrderId(), order);
        Order updatedOrder = producer.confirmOrder(order);

        if (updatedOrder.getStatus() == Order.Status.PENDING) {
            throw new IllegalStateException("Order should be approved or declined");
        }
        if (updatedOrder.getStatus() == Order.Status.DECLINED) {
            map.remove(updatedOrder.getOrderId());
            log.info("Order Declined");
            return updatedOrder;
        }
        return updatedOrder;
    }

}
