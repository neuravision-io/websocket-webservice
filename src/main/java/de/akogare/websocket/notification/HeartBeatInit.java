package de.akogare.websocket.notification;

import de.akogare.websocket.amqp.IOMessage;
import de.akogare.websocket.config.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Component
public class HeartBeatInit {
    private final RabbitTemplate rabbitTemplate;

    private final SimpMessagingTemplate websocketTemplate;

    public HeartBeatInit(RabbitTemplate rabbitTemplate, SimpMessagingTemplate websocketTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.websocketTemplate = websocketTemplate;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        IOMessage IOMessage = new IOMessage(NotificationType.ERROR, NotificationAction.HEARTBEAT, Messages.HEARTBEAT,  UUID.randomUUID().toString(), Date.from(Instant.now()), null);

        return args -> {
            for (int i = 0; i < 5; i++) {
                rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, IOMessage);
                websocketTemplate.convertAndSend("/topic/main", IOMessage);
            }
        };
    }
}
