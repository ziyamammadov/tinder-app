package entity;

import java.time.LocalDateTime;

public class Message {
    private final int sender_id;
    private final int receiver_id;
    private final String message;
    private LocalDateTime time;

    public Message(int sender_id, int receiver_id, String message) {
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public Message(int sender_id, int receiver_id, String message, LocalDateTime time) {
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.message = message;
        this.time = time;
    }

    public int getSender_id() {
        return sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
