package iss.sirius.Repository;

import iss.sirius.Model.Subject;
import iss.sirius.Repository.Interfaces.SubjectRepository;
import iss.sirius.Repository.Interfaces.SubjectRepository;
import iss.sirius.Repository.Mappers.SubjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SubjectImpl implements SubjectRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public Subject save(Subject subject) throws Exception {
        int id = insert(subject);
        subject.setId(id);
        return subject;
    }

    @Override
    public Optional<Subject> findById(int id) {
        List<Subject> subjects = template.query("SELECT * FROM Subjects WHERE id = ?", new SubjectMapper(), id);
        return subjects.isEmpty() ? Optional.empty() : Optional.of(subjects.get(0));
    }

    @Override
    public List<Subject> findAll() {
        return template.query("SELECT * FROM Subjects", new SubjectMapper());
    }

    @Override
    public void remove(Subject subject) {
        template.update("DELETE FROM Subjects WHERE id = ?", subject.getId());
    }

    private Integer insert(Subject subject) {
        return template.update("INSERT INTO Subjects (name) VALUES (?)", subject.getName());
    }

    public void update(Subject subject) {
        template.update("UPDATE Subjects SET name = ? WHERE id = ?", subject.getName());
    }
}
