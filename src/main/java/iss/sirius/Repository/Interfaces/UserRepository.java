package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    public User save(User User) throws Exception;

    public Optional<User> findById(int id);

    public List<User> findAll();

    public void remove(User User);

    public void update(User User);
}
