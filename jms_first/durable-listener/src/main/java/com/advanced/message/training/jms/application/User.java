package com.advanced.message.training.jms.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private String userId;
    private String firstName;
    private String lastName;

    @JsonCreator
    public User(@JsonProperty("userId") String userId, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
