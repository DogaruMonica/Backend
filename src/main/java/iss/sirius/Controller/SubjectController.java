package iss.sirius.Controller;

import iss.sirius.Model.Subject;
import iss.sirius.Repository.Interfaces.SubjectRepository;
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
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public Object getSubject(@PathVariable int id) {
        return subjectRepository.findById(id);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.POST, consumes = "application/json")
    public Object addSubject(@RequestBody Subject subject) throws Exception {
        return subjectRepository.save(subject);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.PUT, consumes = "application/json")
    public void updateSubject(@RequestBody Subject subject) throws SQLException {
        subjectRepository.update(subject);
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
    public void removeSubject(@PathVariable int id) throws Exception {
        if (subjectRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            subjectRepository.remove(subjectRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public Object getAllSubjects() {
        return subjectRepository.findAll();
    }
}
