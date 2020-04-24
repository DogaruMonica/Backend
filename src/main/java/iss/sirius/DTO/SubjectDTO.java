package iss.sirius.DTO;

import iss.sirius.Model.Teacher;

import java.util.Set;

public class SubjectDTO {
    private int id;
    private String name;
    private Set<Teacher> teachers;

    public SubjectDTO(int id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
