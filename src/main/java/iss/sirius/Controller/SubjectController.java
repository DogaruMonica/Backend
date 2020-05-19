package iss.sirius.Controller;

import iss.sirius.DTO.SubjectDTO;
import iss.sirius.Model.Subject;
import iss.sirius.Repository.SubjectRepository;
import iss.sirius.Repository.TeacherRepository;
import iss.sirius.Service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectService subjectService;
    @Autowired
    TeacherRepository teacherRepository;

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public Object getSubject(@PathVariable int id) throws Exception {
        SubjectDTO subjectDTO = subjectService.findById(id);
        subjectDTO.setTeachers(subjectRepository.findById(id).get().getTeachers());
        return subjectDTO;
    }

    @RequestMapping(value = "/subject", method = RequestMethod.POST, consumes = "application/json")
    public Object addSubject(@RequestBody Subject subject) throws Exception {
        if (subjectRepository.findByName(subject.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subject already exists!");
        }
        return subjectRepository.save(subject);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.PUT, consumes = "application/json")
    public void updateSubject(@RequestBody Subject subject) throws SQLException {
        subjectRepository.save(subject);
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
    public void removeSubject(@PathVariable int id) throws Exception {
        if (subjectRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            subjectRepository.delete(subjectRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public Object getAllSubjects() {
        return subjectRepository.findAll();
    }
}
