package iss.sirius.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "chatrooms")
public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "chatroom", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClassroomSubjectChatroom> classroomSubjectChatrooms;

    @OneToMany(mappedBy = "chatroom", cascade = CascadeType.ALL)
    private Set<Message> messages;

    public Chatroom() {
    }

    public Chatroom(int id, Set<ClassroomSubjectChatroom> classroomSubjectChatrooms) {
        this.id = id;
        this.classroomSubjectChatrooms = classroomSubjectChatrooms;
    }

    public Chatroom(Set<ClassroomSubjectChatroom> classroomSubjectChatrooms) {
        this.classroomSubjectChatrooms = classroomSubjectChatrooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ClassroomSubjectChatroom> getClassroomSubjectChatrooms() {
        return classroomSubjectChatrooms;
    }

    public void setClassroomSubjectChatrooms(Set<ClassroomSubjectChatroom> classroomSubjectChatrooms) {
        this.classroomSubjectChatrooms = classroomSubjectChatrooms;
    }
}
