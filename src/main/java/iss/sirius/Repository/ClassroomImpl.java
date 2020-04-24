package iss.sirius.Repository;

import iss.sirius.Model.Classroom;
import iss.sirius.Model.Subject;
import iss.sirius.Repository.Interfaces.ClassroomRepository;
import iss.sirius.Repository.Mappers.ClassroomMapper;
import iss.sirius.Repository.Mappers.SubjectMapper;
import iss.sirius.Repository.Mappers.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClassroomImpl implements ClassroomRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public Classroom save(Classroom classroom) throws Exception {
        int id = insert(classroom);
        classroom.setId(id);
        return classroom;
    }

    @Override
    public Optional<Classroom> findById(int id) {
        List<Classroom> classrooms = template.query("SELECT * FROM Classrooms WHERE id = ?", new ClassroomMapper(), id);
        return classrooms.isEmpty() ? Optional.empty() : Optional.of(classrooms.get(0));
    }

    @Override
    public List<Classroom> findAll() {
        return template.query("SELECT * FROM Classrooms", new ClassroomMapper());
    }

    @Override
    public void remove(Classroom classroom) {
        template.update("DELETE FROM Classrooms WHERE id = ?", classroom.getId());
    }

    private Integer insert(Classroom classroom) {
        return template.update("INSERT INTO Classrooms (name) VALUES (?)", classroom.getName());
    }

    public void update(Classroom classroom) {
        template.update("UPDATE Classrooms SET name = ? WHERE id = ?", classroom.getName());
    }

    @Override
    public List<Subject> getSubjects(int classroomID) {
        return template.query("SELECT Subjects.* FROM Subjects INNER JOIN classroom_subject ON Subjects.id = classroom_subject.subjectid AND classroom_subject.classroomid = ?", new SubjectMapper(), classroomID);
    }
}
