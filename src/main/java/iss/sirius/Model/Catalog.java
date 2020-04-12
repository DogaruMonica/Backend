package iss.sirius.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "catalogs")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "catalog")
    private List<Pupil> pupils;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Catalog_Subject",
            joinColumns = {@JoinColumn(name = "catalogid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subjectid", referencedColumnName = "id")}
    )
    Set<Subject> subjects = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroomid", referencedColumnName = "id")
    private Classroom classroom;

    @Column(name = "grade")
    private int grade;

    public Catalog(){};

    public Catalog(int id) {
        this.id = id;
    }

    public Catalog(List<Pupil> pupils, Set<Subject> subjects, int grade) {
        this.pupils = pupils;
        this.subjects = subjects;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(List<Pupil> pupils) {
        this.pupils = pupils;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", pupils=" + pupils +
                ", subjects=" + subjects +
                ", grade=" + grade +
                '}';
    }
}
