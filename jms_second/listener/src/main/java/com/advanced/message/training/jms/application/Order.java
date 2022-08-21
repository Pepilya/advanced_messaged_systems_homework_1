package com.advanced.message.training.jms.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String orderId;
    private String productId;
    private Integer amount;
    private Status status = Status.PENDING;


    public enum Status {
        PENDING,
        APPROVED,
        DECLINED
    }

}

