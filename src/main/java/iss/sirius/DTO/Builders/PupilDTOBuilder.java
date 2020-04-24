package iss.sirius.DTO.Builders;

import iss.sirius.DTO.PupilDTO;
import iss.sirius.Model.Pupil;

public class PupilDTOBuilder {
    public static PupilDTO generateDTOFromEntity(Pupil pupil) {
        return new PupilDTO(
                pupil.getId(),
                pupil.getFirstname(),
                pupil.getLastname()
        );
    }

    public static Pupil generateEntityFromDTO(PupilDTO pupilDTO) {
        return new Pupil(
                pupilDTO.getId(),
                pupilDTO.getFirstname(),
                pupilDTO.getLastname()
        );
    }
}
