package de.akogare.websocket.amqp;

import java.util.Date;

public record RabbitMQMessage(String message, String messageId, Date messageDate) {
    @Override
    public String toString() {
        return "{" +
                "\"message\":\"" + message + "\"," +
                "\"messageId\":\"" + messageId + "\"," +
                "\"messageDate\":\"" + messageDate + "\"" +
                "}";
    }

}
