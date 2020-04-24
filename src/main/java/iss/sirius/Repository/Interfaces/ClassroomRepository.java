package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.Classroom;
import iss.sirius.Model.Subject;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepository {
    public Classroom save(Classroom Classroom) throws Exception;

    public Optional<Classroom> findById(int id);

    public List<Classroom> findAll();

    public void remove(Classroom Classroom);

    public void update(Classroom Classroom);

    public List<Subject> getSubjects(int classroomID);
}
