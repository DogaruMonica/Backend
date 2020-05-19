package iss.sirius.Controller;

import iss.sirius.Model.Classroom;
import iss.sirius.Model.ClassroomSubjectTeacher;
import iss.sirius.Model.Subject;
import iss.sirius.Model.Teacher;
import iss.sirius.Repository.ClassroomRepository;
import iss.sirius.Repository.ClassroomSubjectTeacherRepository;
import iss.sirius.Repository.SubjectRepository;
import iss.sirius.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ClassroomSubjectTeacherController {
    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ClassroomSubjectTeacherRepository classroomSubjectTeacherRepository;

    @RequestMapping(value = "/classroom/{classroomId}/{subjectId}/{teacherId}", method = RequestMethod.POST)
    public Object addClassroomSubjectTeacher(@PathVariable int classroomId, @PathVariable int subjectId, @PathVariable int teacherId) throws Exception {
        Classroom classroom = classroomRepository.findById(classroomId).get();
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        ClassroomSubjectTeacher classroomSubjectTeacher = new ClassroomSubjectTeacher(classroom, subject, teacher);
        return classroomSubjectTeacherRepository.save(classroomSubjectTeacher);
    }

    @RequestMapping(value = "/classroomSubjectTeacher/{id}", method = RequestMethod.DELETE)
    public void removeClassroomSubjectChatroom(@PathVariable int id) throws Exception {
        if (classroomSubjectTeacherRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            classroomSubjectTeacherRepository.delete(classroomSubjectTeacherRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/classroomSubjectTeacher", method = RequestMethod.GET)
    public Object getAllClassroomSubjectTeachers() {
        return classroomSubjectTeacherRepository.findAll();
    }

    @RequestMapping(value = "/classroomSubjectTeacher/{classroomid}", method = RequestMethod.GET)
    public Object getTeachersPerClassroom(@PathVariable int classroomid) {
        Classroom classroom = classroomRepository.findById(classroomid).get();
        return classroomSubjectTeacherRepository.findByClassroom(classroom);
    }
}
