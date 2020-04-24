package iss.sirius.DTO.Builders;

import iss.sirius.DTO.ClassroomDTO;
import iss.sirius.Model.Classroom;

public class ClassroomDTOBuilder {
    public static ClassroomDTO generateDTOFromEntity(Classroom classroom) {
        return new ClassroomDTO(
                classroom.getId(),
                classroom.getName()
        );
    }

    public static Classroom generateEntityFromDTO(ClassroomDTO classroomDTO) {
        return new Classroom(
                classroomDTO.getId(),
                classroomDTO.getName()
        );
    }
}
