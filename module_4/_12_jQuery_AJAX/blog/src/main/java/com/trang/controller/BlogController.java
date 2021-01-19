package com.trang.controller;

import com.trang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = {" ", "/"})
    public String showList(Pageable pageable, Model model){

    }
}
