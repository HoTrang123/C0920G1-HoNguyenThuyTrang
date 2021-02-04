package com.codegym.service.impl;

import com.codegym.model.QuestionType;
import com.codegym.model.User;
import com.codegym.repository.QuestionTypeRepository;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
