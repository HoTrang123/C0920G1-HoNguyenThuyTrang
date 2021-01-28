package com.codegym.controller;

import com.codegym.model.user.User;
import com.codegym.repository.user.RoleRepository;
import com.codegym.repository.user.UserRepository;
import com.codegym.service.user.RoleService;
import com.codegym.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping({"/register"})
    public String showRegister(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roleList", roleService.findAll());
        return "login/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        user.setEnabled(true);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        userService.save(user);
        return "redirect:/login";
    }
}