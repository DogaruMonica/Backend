package iss.sirius.DTO;

import iss.sirius.Model.Catalog;

public class GradeDTO {
    private int id;
    private Catalog catalog;
    private int pupil;
    private int subject;
    private int grade;

    public GradeDTO(int id, int pupil, int subject, int grade) {
        this.id = id;
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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
