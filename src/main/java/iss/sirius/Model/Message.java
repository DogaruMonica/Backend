package iss.sirius.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chatroom_id", referencedColumnName = "id")
    private Chatroom chatroom;

    private String message;
    private int userId;
    private LocalDateTime dateTime;

    public Message() {

    }
    public Message(int id, Chatroom chatroom, String message, int userId, LocalDateTime dateTime) {
        this.id = id;
        this.chatroom = chatroom;
        this.message = message;
        this.userId = userId;
        this.dateTime = dateTime;
    }
    public Message(Chatroom chatroom, String message, int userId, LocalDateTime dateTime) {
        this.chatroom = chatroom;
        this.message = message;
        this.userId = userId;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
