package iss.sirius.Service;

import iss.sirius.DTO.Builders.UserDTOBuilder;
import iss.sirius.DTO.UserDTO;
import iss.sirius.Model.User;
import iss.sirius.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null)
            return null;
        else return UserDTOBuilder.generateDTOFromEntity(user);
    }

    public UserDTO login(String email, String password) {
        if (!Objects.isNull(findByEmail(email))) {
            if (findByEmail(email).getPassword().equals(password)) {
                return findByEmail(email);
            }
        }
        return null;
    }

}
