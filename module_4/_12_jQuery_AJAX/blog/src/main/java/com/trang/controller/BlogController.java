package com.trang.controller;

import com.trang.model.Blog;
import com.trang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = {"","/"})
    public String showList(Pageable pageable, Model model) {
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "blogs/list";
    }


    @GetMapping(value = "/create")
    public String showCreate(Blog blog, Model model) {
        model.addAttribute("blog", blog);
        return "blogs/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog/";
    }
}
