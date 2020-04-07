package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.Pupil;

import java.util.List;
import java.util.Optional;


public interface PupilRepository {
    public Pupil save(Pupil Pupil) throws Exception;

    public Optional<Pupil> findById(int id);

    public List<Pupil> findAll();

    public void remove(Pupil Pupil);

    public void update(Pupil Pupil);
}
