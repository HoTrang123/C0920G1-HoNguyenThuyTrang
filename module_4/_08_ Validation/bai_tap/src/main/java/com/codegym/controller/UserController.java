package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/user")
    public String showForm(Model model){
        model.addAttribute("users", new User());
        return "index";
    }
    @PostMapping("/user")
    public String checkValidation (@Valid @ModelAttribute(name = "users") User users, BindingResult bindingResult, Model model){
        new User().validate(users, bindingResult);
        if (bindingResult.hasErrors()){
            return "index";
        }
        else {
            model.addAttribute("users", users);
            return "result";
        }
    }
}
