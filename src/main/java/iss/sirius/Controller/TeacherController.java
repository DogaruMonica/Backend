package iss.sirius.Controller;

import iss.sirius.Model.Classroom;
import iss.sirius.Model.ClassroomSubjectChatroom;
import iss.sirius.Model.ClassroomSubjectTeacher;
import iss.sirius.Model.Teacher;
import iss.sirius.Model.User;
import iss.sirius.Repository.ClassroomSubjectChatroomRepository;
import iss.sirius.Repository.ClassroomSubjectTeacherRepository;
import iss.sirius.Repository.TeacherRepository;
import iss.sirius.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClassroomSubjectChatroomRepository classroomSubjectChatroomRepository;
    @Autowired
    ClassroomSubjectTeacherRepository classroomSubjectTeacherRepository;

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
        } else {
            throw new Exception("invalid user");
        }
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.PUT, consumes = "application/json")
    public void updateTeacher(@RequestBody Teacher teacher) throws SQLException {
        teacherRepository.save(teacher);
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE)
    public void removeTeacher(@PathVariable int id) throws Exception {
        if (teacherRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            teacherRepository.delete(teacherRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public Object getAllTeachers() {
        return teacherRepository.findAll();
    }

    @RequestMapping(value = "/teacher/{teacherid}/subject/{subjectid}", method = RequestMethod.POST)
    public void attachTeacherToSubject(@PathVariable int teacherid, @PathVariable int subjectid) throws Exception {
        teacherRepository.attachTeacherToSubject(teacherid, subjectid);
    }

    @RequestMapping(value = "/teacher/{teacherid}/chatrooms", method = RequestMethod.GET)
    public Object getClassroomSubject(@PathVariable int teacherid) {
        Teacher teacher = teacherRepository.findById(teacherid).get();
        List<ClassroomSubjectChatroom> classroomSubjectChatrooms = new ArrayList<>();
        List<ClassroomSubjectTeacher> classroomSubjectTeachers = classroomSubjectTeacherRepository.findByTeacher(teacher);
        for (ClassroomSubjectTeacher classroomSubjectTeacher : classroomSubjectTeachers) {
            ClassroomSubjectChatroom classroomSubjectChatroom = classroomSubjectChatroomRepository.findByClassroomAndSubject(classroomSubjectTeacher.getClassroom().getId(), classroomSubjectTeacher.getSubject().getId());
            classroomSubjectChatrooms.add(classroomSubjectChatroom);
        }
        return classroomSubjectChatrooms;
    }

    @RequestMapping(value = "/teacher/user/{idUser}", method = RequestMethod.GET)
    public Object getTeacherByUser(@PathVariable int idUser) {
        return teacherRepository.findByUserId(idUser);
    }
}
