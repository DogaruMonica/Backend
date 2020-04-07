package iss.sirius.Controller;

import iss.sirius.Model.Teacher;
import iss.sirius.Repository.Interfaces.TeacherRepository;
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

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public Object getTeacher(@PathVariable int id) {
        return teacherRepository.findById(id);
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST, consumes = "application/json")
    public void addTeacher(@RequestBody Teacher teacher) throws Exception {
        teacherRepository.save(teacher);
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
