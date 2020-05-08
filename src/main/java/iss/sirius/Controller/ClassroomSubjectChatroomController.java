package iss.sirius.Controller;

import iss.sirius.Model.Chatroom;
import iss.sirius.Model.Classroom;
import iss.sirius.Model.ClassroomSubjectChatroom;
import iss.sirius.Model.Subject;
import iss.sirius.Repository.ChatroomRepository;
import iss.sirius.Repository.ClassroomRepository;
import iss.sirius.Repository.ClassroomSubjectChatroomRepository;
import iss.sirius.Repository.SubjectRepository;
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
    ChatroomRepository chatroomRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ClassroomSubjectChatroomRepository classroomSubjectChatroomRepository;

    @RequestMapping(value = "/classroomSubjectChatroom/{id}", method = RequestMethod.GET)
    public Object getClassroomSubjectChatroom(@PathVariable int id) {
        return classroomSubjectChatroomRepository.findById(id);
    }
    @RequestMapping(value = "classroom/classroomSubjectChatroom/{id}", method = RequestMethod.GET)
    public Object getClassroomSubjectChatroomOfClassroom(@PathVariable int id) {
        return classroomSubjectChatroomRepository.findAllByClassroom_Id(id);
    }

    @RequestMapping(value = "/classroom/{classroomId}/{subjectId}", method = RequestMethod.POST)
    public Object addClassroomSubjectChatroom(@PathVariable int classroomId, @PathVariable int subjectId) throws Exception {
        Chatroom chatroom = new Chatroom();
        chatroom = chatroomRepository.save(chatroom);
        Classroom classroom = classroomRepository.findById(classroomId).get();
        Subject subject = subjectRepository.findById(subjectId).get();
        ClassroomSubjectChatroom classroomSubjectChatroom = new ClassroomSubjectChatroom(classroom, subject, chatroom);
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
