package iss.sirius.Repository;

import iss.sirius.Model.Catalog;
import iss.sirius.Model.Classroom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClassroomRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Test
    public void findClassroomByIdTest() {
        Catalog catalog = new Catalog();
        entityManager.persist(catalog);
        entityManager.flush();

        Classroom classroom = new Classroom(catalog, "TestClassroom");
        entityManager.persist(classroom);
        entityManager.flush();

        Classroom returnedClassroom = classroomRepository.findById(classroom.getId()).get();

        assertThat(returnedClassroom.getId()).isEqualTo(classroom.getId());
        assertThat(returnedClassroom.getName()).isEqualTo(classroom.getName());
        assertThat(returnedClassroom.getCatalog()).isEqualTo(classroom.getCatalog());
    }
}
