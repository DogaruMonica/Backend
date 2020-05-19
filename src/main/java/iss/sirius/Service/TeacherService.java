package iss.sirius.Service;

import iss.sirius.DTO.Builders.TeacherDTOBuilder;
import iss.sirius.DTO.TeacherDTO;
import iss.sirius.Model.Teacher;
import iss.sirius.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherService {
   @Autowired
    TeacherRepository teacherRepository;

    public TeacherDTO findTeacherByUserId(int userid) {
        Teacher teacher = teacherRepository.findByUserId(userid);
        if (teacher == null)
            return null;
        else return TeacherDTOBuilder.generateDTOFromEntity(teacher);
    }
}
