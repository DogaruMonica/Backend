package iss.sirius.DTO;

import iss.sirius.Model.Classroom;

public class CatalogDTO {
    private int id;
    private Classroom classroom;

    public CatalogDTO(int id) {
        this.id = id;
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
}
