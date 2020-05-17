package iss.sirius.Repository;

import iss.sirius.Model.ClassroomSubjectTeacher;
import iss.sirius.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomSubjectTeacherRepository extends JpaRepository<ClassroomSubjectTeacher, Integer> {
    List<ClassroomSubjectTeacher> findByTeacher(Teacher teacher);
}
