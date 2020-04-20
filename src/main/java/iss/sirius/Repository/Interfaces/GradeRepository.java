package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeRepository {
    public Grade save(Grade Grade) throws Exception;

    public Optional<Grade> findById(int id);

    public List<Grade> findAll();

    public void remove(Grade Grade);

    public void update(Grade Grade);
}
