package iss.sirius.Controller;

import iss.sirius.Model.Classroom;
import iss.sirius.Repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ClassroomController {
        @Autowired
        ClassroomRepository classroomRepository;

        @RequestMapping(value = "/classroom/{id}", method = RequestMethod.GET)
        public Object getClassroom(@PathVariable int id) {
            return classroomRepository.findById(id);
        }

        @RequestMapping(value = "/classroom", method = RequestMethod.POST, consumes = "application/json")
        public Object addClassroom(@RequestBody Classroom classroom) throws Exception {
            return classroomRepository.save(classroom);
        }

        @RequestMapping(value = "/classroom", method = RequestMethod.PUT, consumes = "application/json")
        public void updateClassroom(@RequestBody Classroom classroom) throws SQLException {
            classroomRepository.save(classroom);
        }

        @RequestMapping(value = "/classroom/{id}", method = RequestMethod.DELETE)
        public void removeClassroom(@PathVariable int id) throws Exception {
            if (classroomRepository.findById(id).equals(Optional.empty())) {
                throw new Exception("Why remove something that doesn't exist ????");
            } else {
                classroomRepository.delete(classroomRepository.findById(id).get());
            }
        }

        @RequestMapping(value = "/classroom", method = RequestMethod.GET)
        public Object getAllClassrooms() {
            return classroomRepository.findAll();
        }

}
