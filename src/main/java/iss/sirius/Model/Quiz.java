package iss.sirius.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "quiz", cascade = {CascadeType.ALL})
    private Set<Question> questions;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "classroomSubjectChatroom_id", referencedColumnName = "id")
    private ClassroomSubjectChatroom classroomSubjectChatroom;

    @OneToMany(mappedBy = "quiz", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<QuizPupil> quizPupils;

    public Quiz() {
    }

    public Quiz(String name) {
        this.name = name;
        this.active = false;
    }

    public Quiz(String name, ClassroomSubjectChatroom classroomSubjectChatroom) {
        this.name = name;
        this.classroomSubjectChatroom = classroomSubjectChatroom;
        this.active = false;
    }

    public Quiz(int id, String name, Set<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public Quiz(String name, Set<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Quiz(String name, int pupil_id, int score, Set<Question> questions, ClassroomSubjectChatroom classroomSubjectChatroom) {
        this.name = name;
        this.questions = questions;
        this.classroomSubjectChatroom = classroomSubjectChatroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public ClassroomSubjectChatroom getClassroomSubjectChatroom() {
        return classroomSubjectChatroom;
    }

    public void setClassroomSubjectChatroom(ClassroomSubjectChatroom classroomSubjectChatroom) {
        this.classroomSubjectChatroom = classroomSubjectChatroom;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<QuizPupil> getQuizPupils() {
        return quizPupils;
    }

    public void setQuizPupils(Set<QuizPupil> quizPupils) {
        this.quizPupils = quizPupils;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", questions=" + questions +
                ", classroomSubjectChatroom=" + classroomSubjectChatroom +
                ", quizPupils=" + quizPupils +
                '}';
    }
}
