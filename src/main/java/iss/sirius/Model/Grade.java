package iss.sirius.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "catalogid", referencedColumnName = "id")
    private Catalog catalog;

    @Column(name = "pupil")
    private int pupil;

    @Column(name = "subject")
    private int subject;

    @Column(name = "grade")
    private int grade;

    public Grade() {
    }
    public Grade(int id, int pupil, int subject, int grade) {
        this.id = id;
        this.pupil = pupil;
        this.subject = subject;
        this.grade = grade;
    }

    public Grade(int pupil, int subject, int grade) {
        this.pupil = pupil;
        this.subject = subject;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getPupil() {
        return pupil;
    }

    public void setPupil(int pupil) {
        this.pupil = pupil;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", catalog=" + catalog +
                ", pupil=" + pupil +
                ", subject=" + subject +
                ", grade=" + grade +
                '}';
    }
}
