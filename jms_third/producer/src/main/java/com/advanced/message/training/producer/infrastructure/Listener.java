//package com.advanced.message.training.producer.infrastructure;
//
//import com.advanced.message.training.producer.application.service.model.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class Listener {
//
//    @JmsListener(destination = "Consumer.myConsumer1.VirtualTopic.MAIN", containerFactory = "jmsListenerContainerFactory")
//    public void processEvent_1(User user) {
//        log.info("Register user with name == {} on consumer == 1", user.getFirstName());
//    }
//
//    @JmsListener(destination = "Consumer.myConsumer2.VirtualTopic.MAIN", containerFactory = "jmsListenerContainerFactory")
//    public void processEvent_2(User user) {
//        log.info("Register user with name == {} on consumer == 2", user.getFirstName());
//    }
//
//    @JmsListener(destination = "Consumer.myConsumer3.VirtualTopic.MAIN", containerFactory = "jmsListenerContainerFactory")
//    public void processEvent_3(User user) {
//        log.info("Register user with name == {} on consumer == 3", user.getFirstName());
//    }
//
//    @JmsListener(destination = "Consumer.myConsumer4.VirtualTopic.MAIN", containerFactory = "jmsListenerContainerFactory")
//    public void processEvent_4(User user) {
//        log.info("Register user with name == {} on consumer == 4", user.getFirstName());
//    }
//
//    @JmsListener(destination = "Consumer.myConsumer5.VirtualTopic.MAIN", containerFactory = "jmsListenerContainerFactory")
//    public void processEvent_5(User user) {
//        log.info("Register user with name == {} on consumer == 5", user.getFirstName());
//    }
//
//}
