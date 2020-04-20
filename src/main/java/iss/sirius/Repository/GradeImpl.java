package iss.sirius.Repository;

import iss.sirius.Model.Grade;
import iss.sirius.Repository.Interfaces.GradeRepository;
import iss.sirius.Repository.Mappers.GradeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GradeImpl implements GradeRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public Grade save(Grade grade) throws Exception {
        int id = insert(grade);
        grade.setId(id);
        return grade;
    }

    @Override
    public Optional<Grade> findById(int id) {
        List<Grade> grades = template.query("SELECT * FROM Grades WHERE id = ?", new GradeMapper(), id);
        return grades.isEmpty() ? Optional.empty() : Optional.of(grades.get(0));
    }

    @Override
    public List<Grade> findAll() {
        return template.query("SELECT * FROM Grades", new GradeMapper());
    }

    @Override
    public void remove(Grade grade) {
        template.update("DELETE FROM Grades WHERE id = ?", grade.getId());
    }

    private Integer insert(Grade grade) {
        return template.update("INSERT INTO Grades (pupil, subject, grade) VALUES (?,?,?)", grade.getPupil(), grade.getSubject(), grade.getGrade());
    }

    public void update(Grade grade) {
        template.update("UPDATE Grades SET pupil = ?, subject = ?, grade = ? WHERE id = ?", grade.getPupil(), grade.getSubject(), grade.getGrade());
    }
}
