package iss.sirius.Controller;

import iss.sirius.Model.Teacher;
import iss.sirius.Model.User;
import iss.sirius.Repository.Interfaces.TeacherRepository;
import iss.sirius.Repository.Interfaces.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public Object getTeacher(@PathVariable int id) {
        return teacherRepository.findById(id);
    }

    @RequestMapping(value = "/teacher/{userid}", method = RequestMethod.POST, consumes = "application/json")
    public Object addTeacher(@RequestBody Teacher teacher, @PathVariable int userid) throws Exception {
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()) {
            teacher.setUser(user.get());
            return teacherRepository.save(teacher);
        }
        else {
            throw new Exception("invalid user");
        }
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.PUT, consumes = "application/json")
    public void updateTeacher(@RequestBody Teacher teacher) throws SQLException {
        teacherRepository.update(teacher);
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE)
    public void removeTeacher(@PathVariable int id) throws Exception {
        if (teacherRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            teacherRepository.remove(teacherRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public Object getAllTeachers() {
        return teacherRepository.findAll();
    }
}
