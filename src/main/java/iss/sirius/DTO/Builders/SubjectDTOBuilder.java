package iss.sirius.DTO.Builders;

import iss.sirius.DTO.SubjectDTO;
import iss.sirius.Model.Subject;

public class SubjectDTOBuilder {
    public static SubjectDTO generateDTOFromEntity(Subject subject) {
        return new SubjectDTO(
                subject.getId(),
                subject.getName()
        );
    }

    public static Subject generateEntityFromDTO(SubjectDTO subjectDTO) {
        return new Subject(
                subjectDTO.getId(),
                subjectDTO.getName()
        );
    }
}
