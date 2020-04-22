package iss.sirius.Controller;

import iss.sirius.Model.Pupil;
import iss.sirius.Model.User;
import iss.sirius.Repository.Interfaces.ClassroomRepository;
import iss.sirius.Repository.Interfaces.PupilRepository;
import iss.sirius.Repository.Interfaces.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PupilController {
    @Autowired
    PupilRepository pupilRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/pupil/{id}", method = RequestMethod.GET)
    public Object getPupil(@PathVariable int id) {
        return pupilRepository.findById(id);
    }

    @RequestMapping(value = "/pupil/{userid}", method = RequestMethod.POST, consumes = "application/json")
    public void addPupil(@RequestBody Pupil pupil, @PathVariable int userid) throws Exception {
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()) {
            pupil.setUser(user.get());
            pupilRepository.save(pupil);
        }
        else {
            throw new Exception("invalid user");
        }
    }

    @RequestMapping(value = "/pupil", method = RequestMethod.PUT, consumes = "application/json")
    public void updatePupil(@RequestBody Pupil pupil) throws SQLException {
        pupilRepository.update(pupil);
    }

    @RequestMapping(value = "/pupil/{id}", method = RequestMethod.DELETE)
    public void removePupil(@PathVariable int id) throws Exception {
        if (pupilRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            pupilRepository.remove(pupilRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/pupil", method = RequestMethod.GET)
    public Object getAllPupils() {
        List<Pupil> lista =pupilRepository.findAll();
        return pupilRepository.findAll();
    }
}
