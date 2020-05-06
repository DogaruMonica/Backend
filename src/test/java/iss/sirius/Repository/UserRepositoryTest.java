package iss.sirius.Repository;

import iss.sirius.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByIdTest() {
        User user = new User("test@test.com", "test", "pupil");
        entityManager.persist(user);
        entityManager.flush();

        User returnedUser = userRepository.findById(user.getId()).get();

        assertThat(returnedUser.getId()).isEqualTo(user.getId());
    }

    @Test
    public void findUserByEmailTest() {
        User user = new User("test@test.com", "test", "pupil");
        entityManager.persist(user);
        entityManager.flush();

        User returnedUser = userRepository.findByEmail(user.getEmail());

        assertThat(returnedUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void findAllUsersTest() {
        User user = new User("test@test.com", "test", "pupil");
        User user2 = new User("test2@test.com", "test", "pupil");
        User user3 = new User("test3@test.com", "test", "pupil");
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        users.add(user3);

        entityManager.persist(user);
        entityManager.flush();
        entityManager.persist(user2);
        entityManager.flush();
        entityManager.persist(user3);
        entityManager.flush();

        List<User> returnedUsers = userRepository.findAll();

        assertThat(users.size()).isEqualTo(returnedUsers.size());
    }

    @Test
    public void deleteUserTest() {
        User user = new User("test@test.com", "test", "pupil");
        entityManager.persist(user);
        entityManager.flush();

        entityManager.remove(user);
        entityManager.flush();

        List<User> returnedUsers = userRepository.findAll();

        assertThat(0).isEqualTo(returnedUsers.size());
    }

}
