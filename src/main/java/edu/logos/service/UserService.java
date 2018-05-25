package edu.logos.service;

import edu.logos.dto.filter.RockyFilter;
import edu.logos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User findUserByID(int id) throws Exception;

    List<User> findAllUsers();

    List<User> findAllByFilter(RockyFilter filter);

    Page<User> findUserByPAge(Pageable pageable);

    Page<User> findUsersByPage(Pageable pageable, RockyFilter filter);
}
