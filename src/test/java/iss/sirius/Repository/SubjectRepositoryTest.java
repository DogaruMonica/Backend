package iss.sirius.Repository;

import iss.sirius.Model.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SubjectRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void findSubjectByIdTest() {
        Subject subject = new Subject("TestSubject");
        entityManager.persist(subject);
        entityManager.flush();

        Subject returnedSubject = subjectRepository.findById(subject.getId()).get();

        assertThat(returnedSubject.getId()).isEqualTo(subject.getId());
        assertThat(returnedSubject.getName()).isEqualTo(subject.getName());
    }
}
