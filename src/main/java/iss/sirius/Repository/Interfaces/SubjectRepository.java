package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    public Subject save(Subject Subject) throws Exception;

    public Optional<Subject> findById(int id);

    public List<Subject> findAll();

    public void remove(Subject Subject);

    public void update(Subject Subject);
}
