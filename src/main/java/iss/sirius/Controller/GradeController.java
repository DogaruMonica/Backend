package iss.sirius.Controller;

import iss.sirius.Model.Grade;
import iss.sirius.Model.Pupil;
import iss.sirius.Repository.GradeRepository;
import iss.sirius.Repository.PupilRepository;
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
public class GradeController {
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    PupilRepository pupilRepository;

    @RequestMapping(value = "/grade/{id}", method = RequestMethod.GET)
    public Object getGrade(@PathVariable int id) {
        return gradeRepository.findById(id);
    }

    @RequestMapping(value = "/grade/pupil/{id}", method = RequestMethod.GET)
    public Object getPupilGrades(@PathVariable int id) {
        Pupil pupil = pupilRepository.findByUserId(id);
        return gradeRepository.findByPupil(pupil.getId());
    }

    @RequestMapping(value = "/grade", method = RequestMethod.POST, consumes = "application/json")
    public Object addGrade(@RequestBody Grade grade) throws Exception {
        return gradeRepository.save(grade);
    }

    @RequestMapping(value = "/grade", method = RequestMethod.PUT, consumes = "application/json")
    public void updateGrade(@RequestBody Grade grade) throws SQLException {
        gradeRepository.save(grade);
    }

    @RequestMapping(value = "/grade/{id}", method = RequestMethod.DELETE)
    public void removeGrade(@PathVariable int id) throws Exception {
        if (gradeRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            gradeRepository.delete(gradeRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/grade", method = RequestMethod.GET)
    public Object getAllGrades() {
        return gradeRepository.findAll();
    }
}
