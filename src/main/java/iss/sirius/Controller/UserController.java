package iss.sirius.Controller;

import iss.sirius.Model.User;
import iss.sirius.Repository.UserRepository;
import iss.sirius.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Object getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public Object addUser(@RequestBody User user) throws Exception {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = "application/json")
    public void updateUser(@RequestBody User user) throws SQLException {
        userRepository.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable int id) throws Exception {
        if (userRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            userRepository.delete(userRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, consumes = "application/json")
    public Object login(@RequestBody User userAux) throws Exception {
        return userService.login(userAux.getEmail(), userAux.getPassword());
    }
}
