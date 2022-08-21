//package com.advanced.message.training.producer.infrastructure;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.SessionCallback;
//import org.springframework.jms.support.JmsUtils;
//import org.springframework.jms.support.destination.DestinationResolver;
//import org.springframework.stereotype.Component;
//
//import javax.jms.*;
//import java.util.UUID;
//
//@Component
//public class Requestor {
//
//    private static final class ProducerConsumer implements SessionCallback<Message> {
//        private static final int TIMEOUT = 5000;
//        private final String msg;
//        private final DestinationResolver destinationResolver;
//        private final String queue;
//        public ProducerConsumer( final String msg, String queue, final DestinationResolver destinationResolver ) {
//            this.msg = msg;
//            this.queue = queue;
//            this.destinationResolver = destinationResolver;
//        }
//        public Message doInJms( final Session session ) throws JMSException {
//            MessageConsumer consumer = null;
//            MessageProducer producer = null;
//            try {
//                final String correlationId = UUID.randomUUID().toString();
//                final Destination requestQueue =
//                        destinationResolver.resolveDestinationName( session, queue+".request", false );
//                final Destination replyQueue =
//                        destinationResolver.resolveDestinationName( session, queue+".response", false );
//                // Create the consumer first!
//                consumer = session.createConsumer( replyQueue, "JMSCorrelationID = '" + correlationId + "'" );
//                final TextMessage textMessage = session.createTextMessage( msg );
//                textMessage.setJMSCorrelationID( correlationId );
//                textMessage.setJMSReplyTo( replyQueue );
//                // Send the request second!
//                producer = session.createProducer( requestQueue );
//                producer.send( requestQueue, textMessage );
//                // Block on receiving the response with a timeout
//                return consumer.receive( TIMEOUT );
//            }
//            finally {
//                // Don't forget to close your resources
//                JmsUtils.closeMessageConsumer( consumer );
//                JmsUtils.closeMessageProducer( producer );
//            }
//        }
//    }
//    private final JmsTemplate jmsTemplate;
//    @Autowired
//    public Requestor( final JmsTemplate jmsTemplate ) {
//        this.jmsTemplate = jmsTemplate;
//    }
//    public Message request(final String request, String queue ) {
//        // Must pass true as the second param to start the connection
//        return jmsTemplate.execute( new ProducerConsumer( request, queue, jmsTemplate.getDestinationResolver()), true );
//    }
//}