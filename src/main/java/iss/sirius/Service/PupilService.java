package iss.sirius.Service;

import iss.sirius.DTO.Builders.PupilDTOBuilder;
import iss.sirius.DTO.PupilDTO;
import iss.sirius.Model.Pupil;
import iss.sirius.Repository.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PupilService {
    @Autowired
    PupilRepository pupilRepository;
    public PupilDTO findPupilByUserId(int userid) {
        Pupil pupil =  pupilRepository.findByUserId(userid);
        if (pupil == null)
            return null;
        else return PupilDTOBuilder.generateDTOFromEntity(pupil);
    }
}
