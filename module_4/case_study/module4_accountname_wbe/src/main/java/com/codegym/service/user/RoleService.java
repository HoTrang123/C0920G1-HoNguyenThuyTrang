package com.codegym.service.user;

import com.codegym.model.user.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
}