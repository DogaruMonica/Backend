package iss.sirius.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Classroom_Teacher",
            joinColumns = {@JoinColumn(name = "classroomid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "teacherid", referencedColumnName = "id")}
    )
    Set<Teacher> teachers = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "classroom", fetch =  FetchType.EAGER)
    private List<Pupil> pupils;

    @JsonManagedReference
    @OneToOne(mappedBy = "classroom")
    private Catalog catalog;

    @OneToMany(mappedBy = "classroom", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClassroomSubjectChatroom> classroomSubjectChatrooms;

    @Column(name = "name")
    private String name;

    public Classroom() {
    }

    public Classroom(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Classroom(int id, Catalog catalog, String name) {
        this.id = id;
        this.catalog = catalog;
        this.name = name;
    }

    public Classroom(Catalog catalog, String name) {
        this.catalog = catalog;
        this.name = name;
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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", pupils=" + pupils +
                ", catalog=" + catalog +
                ", name='" + name + '\'' +
                '}';
    }
}
