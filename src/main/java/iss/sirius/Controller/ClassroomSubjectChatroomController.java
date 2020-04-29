package iss.sirius.Controller;

import iss.sirius.Model.ClassroomSubjectChatroom;
import iss.sirius.Repository.ClassroomSubjectChatroomRepository;
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
public class ClassroomSubjectChatroomController {
    @Autowired
    ClassroomSubjectChatroomRepository classroomSubjectChatroomRepository;

    @RequestMapping(value = "/classroomSubjectChatroom/{id}", method = RequestMethod.GET)
    public Object getClassroomSubjectChatroom(@PathVariable int id) {
        return classroomSubjectChatroomRepository.findById(id);
    }

    @RequestMapping(value = "/classroomSubjectChatroom", method = RequestMethod.POST, consumes = "application/json")
    public Object addClassroomSubjectChatroom(@RequestBody ClassroomSubjectChatroom classroomSubjectChatroom) throws Exception {
        return classroomSubjectChatroomRepository.save(classroomSubjectChatroom);
    }

    @RequestMapping(value = "/classroomSubjectChatroom", method = RequestMethod.PUT, consumes = "application/json")
    public void updateClassroomSubjectChatroom(@RequestBody ClassroomSubjectChatroom classroomSubjectChatroom) throws SQLException {
        classroomSubjectChatroomRepository.save(classroomSubjectChatroom);
    }

    @RequestMapping(value = "/classroomSubjectChatroom/{id}", method = RequestMethod.DELETE)
    public void removeClassroomSubjectChatroom(@PathVariable int id) throws Exception {
        if (classroomSubjectChatroomRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            classroomSubjectChatroomRepository.delete(classroomSubjectChatroomRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/classroomSubjectChatroom", method = RequestMethod.GET)
    public Object getAllClassroomSubjectChatrooms() {
        return classroomSubjectChatroomRepository.findAll();
    }
}
