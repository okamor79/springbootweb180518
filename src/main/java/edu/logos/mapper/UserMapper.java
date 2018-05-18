package edu.logos.mapper;

import edu.logos.dto.UserDTO;
import edu.logos.entity.User;
import org.modelmapper.ModelMapper;

public interface UserMapper {

    static User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        return user;
    }
}
