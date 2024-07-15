package de.akogare.websocket.notification;

public class Notification {

    private String message;
    private NotificationType type;
    private NotificationAction action;

    public Notification(String message, NotificationType type, NotificationAction action) {
        this.message = message;
        this.type = type;
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public NotificationAction getAction() {
        return action;
    }

    public void setAction(NotificationAction action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "{" +
            "\"message\":\"" + message + "\"," +
            "\"type\":\"" + type + "\"," +
            "\"action\":\"" + action + "\"" +
            "}";
    }
}
