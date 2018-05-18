package edu.logos.service.impl;

import edu.logos.entity.User;
import edu.logos.repository.UserRepository;
import edu.logos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByID(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
