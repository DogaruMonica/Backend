package iss.sirius.Repository;

import iss.sirius.Model.Grade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GradeRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GradeRepository gradeRepository;

    @Test
    public void findGradeByIdTest() {
        Grade grade = new Grade(1,1,1);
        entityManager.persist(grade);
        entityManager.flush();

        Grade returnedGrade = gradeRepository.findById(grade.getId()).get();

        assertThat(returnedGrade.getId()).isEqualTo(grade.getId());
        assertThat(returnedGrade.getPupil()).isEqualTo(grade.getPupil());
        assertThat(returnedGrade.getSubject()).isEqualTo(grade.getSubject());
        assertThat(returnedGrade.getGrade()).isEqualTo(grade.getGrade());

    }
}
