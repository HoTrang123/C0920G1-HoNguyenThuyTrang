package com.codegym.controller;

import com.codegym.model.Question;
import com.codegym.service.QuestionService;
import com.codegym.service.QuestionTypeService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionTypeService questionTypeService;
    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/listQuestion"})
    public String listQuestion(Model model, @PageableDefault(size = 3) Pageable pageable) {
//        model.addAttribute("userList", userService.findAll());
//        model.addAttribute("questionTypeList" , questionTypeService.findAll());
       model.addAttribute("questionList" , questionService.findAll(pageable)) ;
       return "list";
    }

    @GetMapping("/create")
    public String createQuestion(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("questionTypeList" , questionTypeService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String saveCreate(@Valid @ModelAttribute("question") Question question, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            model.addAttribute("userList", userService.findAll());
            return "/create";
        } else {
            questionService.save(question);
            return "redirect:/listQuestion";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("giaoDich", questionService.findById(id));
        model.addAttribute("khachHang" , questionTypeService.findAll());
        return "/edit";
    }

    @PostMapping("/updateGiaoDich")
    public String update(@ModelAttribute Question giaoDich){
        questionService.save(giaoDich);
        return "redirect:/listQuestion";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        questionService.delete(id);
        return "redirect:/listQuestion";
    }
//    @GetMapping("/search")
//    public String search(Model model,@RequestParam String title,@RequestParam int questionType){
//        model.addAttribute("questionList",this.questionService.search(title,questionType));
////                model.addAttribute("questionTypeList" , questionTypeService.findAll());
//        return "list";
//    }
}
