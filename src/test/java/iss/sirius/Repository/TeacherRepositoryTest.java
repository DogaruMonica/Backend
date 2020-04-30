package iss.sirius.Repository;

import iss.sirius.Model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeacherRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void findTeacherByIdTest() {
        Teacher teacher = new Teacher("Teacher", "Test");
        entityManager.persist(teacher);
        entityManager.flush();

        Teacher returnedTeacher = teacherRepository.findById(teacher.getId()).get();

        assertThat(returnedTeacher.getId()).isEqualTo(teacher.getId());
    }
}
