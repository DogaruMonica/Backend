package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.Subject;
import iss.sirius.Model.Teacher;

import java.util.List;
import java.util.Optional;


public interface TeacherRepository {
    public Teacher save(Teacher Teacher) throws Exception;

    public Optional<Teacher> findById(int id);

    public List<Teacher> findAll();

    public void remove(Teacher Teacher);

    public void update(Teacher Teacher);

    public List<Teacher> getSubject(int subjectID);

    public Integer attachSubject(int teacherid, int subjectid);
}
