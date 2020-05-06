package iss.sirius.Repository;

import iss.sirius.Model.Pupil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PupilRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PupilRepository pupilRepository;

    @Test
    public void findPupilByIdTest() {
        Pupil pupil = new Pupil("Pupil", "Test");
        entityManager.persist(pupil);
        entityManager.flush();

        Pupil returnedPupil = pupilRepository.findById(pupil.getId()).get();

        assertThat(returnedPupil.getId()).isEqualTo(pupil.getId());
    }
}
