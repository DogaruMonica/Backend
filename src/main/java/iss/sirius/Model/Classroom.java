package iss.sirius.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "subjects")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "classroom")
    private List<Pupil> pupils;

    @OneToOne(mappedBy = "classroom")
    private Catalog catalog;

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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
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
                ", teachers=" + teachers +
                ", pupils=" + pupils +
                ", catalog=" + catalog +
                ", name='" + name + '\'' +
                '}';
    }
}
