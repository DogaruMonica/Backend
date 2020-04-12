package iss.sirius.Repository;

import iss.sirius.Model.User;
import iss.sirius.Repository.Interfaces.UserRepository;
import iss.sirius.Repository.Mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserImpl implements UserRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public User save(User user) throws Exception {
        int id = insert(user);
        user.setId(id);
        return user;
    }

    @Override
    public Optional<User> findById(int id) {
        List<User> users = template.query("SELECT * FROM Users WHERE id = ?", new UserMapper(), id);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    @Override
    public List<User> findAll() {
        return template.query("SELECT * FROM Users", new UserMapper());
    }

    @Override
    public void remove(User user) {
        template.update("DELETE FROM Users WHERE id = ?", user.getId());
    }

    private Integer insert(User user) {
        return template.update("INSERT INTO Users (email, password, role) VALUES (?,?,?)", user.getEmail(), user.getPassword(), user.getRole());
    }

    public void update(User user) {
        template.update("UPDATE Users SET email = ?, password = ? WHERE id = ?", user.getEmail(), user.getPassword());
    }
}
