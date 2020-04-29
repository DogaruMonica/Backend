package iss.sirius.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classroom_subject_chatroom")
public class ClassroomSubjectChatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "chatroom_id", referencedColumnName = "id")
    private Chatroom chatroom;

    public ClassroomSubjectChatroom() {
    }

    public ClassroomSubjectChatroom(int id, Classroom classroom, Subject subject, Chatroom chatroom) {
        this.id = id;
        this.classroom = classroom;
        this.subject = subject;
        this.chatroom = chatroom;
    }

    public ClassroomSubjectChatroom(Classroom classroom, Subject subject, Chatroom chatroom) {
        this.classroom = classroom;
        this.subject = subject;
        this.chatroom = chatroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }
}
