package iss.sirius.DTO.Builders;

import iss.sirius.DTO.GradeDTO;
import iss.sirius.Model.Grade;

public class GradeDTOBuilder {
    public static GradeDTO generateDTOFromEntity(Grade grade) {
        return new GradeDTO(
                grade.getId(),
                grade.getPupil(),
                grade.getSubject(),
                grade.getGrade()
        );
    }

    public static Grade generateEntityFromDTO(GradeDTO gradeDTO) {
        return new Grade(
                gradeDTO.getId(),
                gradeDTO.getPupil(),
                gradeDTO.getSubject(),
                gradeDTO.getGrade()
        );
    }
}
