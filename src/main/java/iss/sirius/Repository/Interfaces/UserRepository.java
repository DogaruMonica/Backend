package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
/*    public User save(User User) throws Exception;

    public Optional<User> findById(int id);

    public Optional<User> findByEmailAndPassword(String email, String password);

    public List<User> findAll();

    public void remove(User User);

    public void update(User User);*/
}
