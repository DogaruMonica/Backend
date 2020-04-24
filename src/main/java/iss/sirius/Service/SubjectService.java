package iss.sirius.Service;

import iss.sirius.DTO.Builders.SubjectDTOBuilder;
import iss.sirius.DTO.SubjectDTO;
import iss.sirius.Model.Subject;
import iss.sirius.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public SubjectDTO findById(int id) throws Exception {
        Optional<Subject> subject  = subjectRepository.findById(id);

        if (!subject.isPresent()) {
            throw new Exception("Subject doesn't exist");
        }
        return SubjectDTOBuilder.generateDTOFromEntity(subject.get());
    }
}
