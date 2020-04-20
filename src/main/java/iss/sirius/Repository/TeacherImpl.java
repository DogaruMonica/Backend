package iss.sirius.Repository;

import iss.sirius.Model.Teacher;
import iss.sirius.Repository.Interfaces.TeacherRepository;
import iss.sirius.Repository.Mappers.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TeacherImpl implements TeacherRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public Teacher save(Teacher teacher) throws Exception {
        int id = insert(teacher);
        teacher.setId(id);
        return teacher;
    }

    @Override
    public Optional<Teacher> findById(int id) {
        List<Teacher> teachers = template.query("SELECT * FROM Teachers WHERE id = ?", new TeacherMapper(), id);
        return teachers.isEmpty() ? Optional.empty() : Optional.of(teachers.get(0));
    }

    @Override
    public List<Teacher> findAll() {
        return template.query("SELECT * FROM Teachers", new TeacherMapper());
    }

    @Override
    public void remove(Teacher teacher) {
        template.update("DELETE FROM Teachers WHERE id = ?", teacher.getId());
    }

    private Integer insert(Teacher teacher) {
        return template.update("INSERT INTO Teachers (firstname, lastname, userid) VALUES (?,?,?)", teacher.getFirstname(), teacher.getLastname(), teacher.getUser().getId());
    }

    public void update(Teacher teacher) {
        template.update("UPDATE Teachers SET firstname = ?, lastname = ? WHERE id = ?", teacher.getFirstname(), teacher.getLastname());
    }
}
