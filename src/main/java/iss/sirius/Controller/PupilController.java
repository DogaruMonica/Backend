package iss.sirius.Controller;

import iss.sirius.Model.Classroom;
import iss.sirius.Model.Pupil;
import iss.sirius.Model.User;
import iss.sirius.Repository.ClassroomRepository;
import iss.sirius.Repository.PupilRepository;
import iss.sirius.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.spi.InFlightMetadataCollector;
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
public class PupilController {
    @Autowired
    PupilRepository pupilRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClassroomRepository classroomRepository;

    @RequestMapping(value = "/pupil/{id}", method = RequestMethod.GET)
    public Object getPupil(@PathVariable int id) {
        return pupilRepository.findById(id);
    }
    @RequestMapping(value = "/classroom/pupil/{id}", method = RequestMethod.GET)
    public Object getPupilC(@PathVariable int id) {
        Pupil p=pupilRepository.findById(id).get();
        return p.getClassroom();
    }
    @RequestMapping(value = "/pupil/user/{idUser}", method = RequestMethod.GET)
    public Object getPupilByUser(@PathVariable int idUser) {
        return pupilRepository.findByUserId(idUser);
    }

    @RequestMapping(value = "/pupil/{userid}/{classroomid}", method = RequestMethod.POST, consumes = "application/json")
    public Object addPupil(@RequestBody Pupil pupil, @PathVariable int userid, @PathVariable int classroomid) throws Exception {
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()) {
            pupil.setUser(user.get());
            Optional<Classroom> classroom = classroomRepository.findById(classroomid);
            if (classroom.isPresent()) {
                pupil.setClassroom(classroom.get());
                return pupilRepository.save(pupil);
            }
            else {
                throw new Exception("Invalid classroom");
            }
        }
        else {
            throw new Exception("Invalid user");
        }
    }

    @RequestMapping(value = "/pupil", method = RequestMethod.PUT, consumes = "application/json")
    public void updatePupil(@RequestBody Pupil pupil) throws SQLException {
        pupilRepository.save(pupil);
    }

    @RequestMapping(value = "/pupil/{id}", method = RequestMethod.DELETE)
    public void removePupil(@PathVariable int id) throws Exception {
        if (pupilRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            pupilRepository.delete(pupilRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/pupil", method = RequestMethod.GET)
    public Object getAllPupils() {
        return pupilRepository.findAll();
    }
}
