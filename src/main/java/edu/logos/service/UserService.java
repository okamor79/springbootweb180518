package edu.logos.service;

import edu.logos.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User findUserByID(int id);

    List<User> findAllUsers();
}
