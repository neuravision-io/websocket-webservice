package de.akogare.websocket.amqp;

import de.akogare.websocket.notification.NotificationAction;
import de.akogare.websocket.notification.NotificationType;

import java.util.Date;

public record IOMessage(NotificationType type, NotificationAction action, String message, String messageId, Date messageDate, OptionalFields optional) {
    @Override
    public String toString() {
        return "{" +
                "\"type\":\"" + type + "\"," +
                "\"action\":\"" + action + "\"," +
                "\"message\":\"" + message + "\"," +
                "\"messageId\":\"" + messageId + "\"," +
                "\"messageDate\":\"" + messageDate + "\"" +
                (optional != null ? ",\"optional\":" + optional : "") +
                "}";
    }

}
