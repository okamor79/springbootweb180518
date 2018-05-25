package edu.logos.mapper;

import edu.logos.dto.UserDTO;
import edu.logos.entity.User;
import org.modelmapper.ModelMapper;

public interface UserMapper {

    static User userDTOToUser(UserDTO userDTO) {
        return new ModelMapper().map(userDTO, User.class);
    }
}
