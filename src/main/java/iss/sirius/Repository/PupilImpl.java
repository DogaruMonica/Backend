package iss.sirius.Repository;

import iss.sirius.Model.Pupil;
import iss.sirius.Repository.Interfaces.PupilRepository;
import iss.sirius.Repository.Mappers.PupilMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PupilImpl implements PupilRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public Pupil save(Pupil pupil) throws Exception {
        int id = insert(pupil);
        pupil.setId(id);
        return pupil;
    }

    @Override
    public Optional<Pupil> findById(int id) {
        List<Pupil> pupils = template.query("SELECT * FROM Pupils WHERE id = ?", new PupilMapper(), id);
        return pupils.isEmpty() ? Optional.empty() : Optional.of(pupils.get(0));
    }

    @Override
    public List<Pupil> findAll() {
        return template.query("SELECT * FROM Pupils", new PupilMapper());
    }

    @Override
    public void remove(Pupil pupil) {
        template.update("DELETE FROM Pupils WHERE id = ?", pupil.getId());
    }

    private Integer insert(Pupil pupil) {
        return template.update("INSERT INTO Pupils (firstname, lastname) VALUES (?)", pupil.getFirstname(), pupil.getLastname());
    }

    public void update(Pupil pupil) {
        template.update("UPDATE Pupils SET firstname = ?, lastname = ? WHERE id = ?", pupil.getFirstname(), pupil.getLastname());
    }
}
