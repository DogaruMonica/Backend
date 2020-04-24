package iss.sirius.DTO.Builders;

import iss.sirius.DTO.UserDTO;
import iss.sirius.Model.User;

public class UserDTOBuilder {
    public static UserDTO generateDTOFromEntity(User user) {
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    public static User generateEntityFromDTO(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole()
        );
    }
}
