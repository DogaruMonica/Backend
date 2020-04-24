package iss.sirius.DTO.Builders;

import iss.sirius.DTO.TeacherDTO;
import iss.sirius.Model.Teacher;

public class TeacherDTOBuilder {
    public static TeacherDTO generateDTOFromEntity(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getFirstname(),
                teacher.getLastname()
        );
    }

    public static Teacher generateEntityFromDTO(TeacherDTO teacherDTO) {
        return new Teacher(
                teacherDTO.getId(),
                teacherDTO.getFirstname(),
                teacherDTO.getLastname()
        );
    }
}
