package de.akogare.websocket.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQMessageConsumer.class);
    public static final String QUEUE = "akogare-main-queue";

    @RabbitListener(queues = QUEUE)
    public void consumeMessage(@Payload RabbitMQMessage message) {
        LOGGER.info("Received message: {}", message);
    }
}
