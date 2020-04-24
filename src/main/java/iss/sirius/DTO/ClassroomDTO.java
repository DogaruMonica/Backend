package iss.sirius.DTO;

import iss.sirius.Model.Catalog;
import iss.sirius.Model.Pupil;

import java.util.List;

public class ClassroomDTO {
    private int id;
    private String name;
    private List<Pupil> pupils;
    private Catalog catalog;

    public ClassroomDTO(int id, String name) {
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
}
