package com.codegym.service.user;

import com.codegym.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUserName(String username);

    void save(User user);
}