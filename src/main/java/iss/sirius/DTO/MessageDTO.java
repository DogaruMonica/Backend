package iss.sirius.DTO;

public class MessageDTO {
    private int id;
    private int chatroom;
    private String message;
    private int userId;

    public MessageDTO() {
    }

    public MessageDTO(int id, int chatroom, String message, int userId) {
        this.id = id;
        this.chatroom = chatroom;
        this.message = message;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatroom() {
        return chatroom;
    }

    public void setChatroom(int chatroom) {
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
}
