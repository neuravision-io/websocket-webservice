package de.akogare.websocket.amqp;

public record OptionalFields(String title, String subtitle) {

    @Override
    public String toString() {
        return "{" + "\"title\":\"" + title + "\"," + "\"subtitle\":\"" + subtitle + "\"" + "}";
    }
}
