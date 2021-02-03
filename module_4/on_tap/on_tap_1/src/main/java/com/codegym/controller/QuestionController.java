package com.codegym.controller;

import com.codegym.model.GiaoDich;
import com.codegym.service.GiaoDichService;
import com.codegym.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@Controller
public class GiaoDichController {
    @Autowired
    GiaoDichService giaoDichService;
    @Autowired
    KhachHangService khachHangService;

    @GetMapping(value = {"/", "/listGiaoDich"})
    public String listGiaoDich(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("khachHangList" , khachHangService.findAll());
       model.addAttribute("giaoDichList" , giaoDichService.findAll(pageable)) ;
       return "list";
    }

    @GetMapping("/create")
    public String createGiaoDich(Model model) {
        model.addAttribute("giaoDich", new GiaoDich());
        model.addAttribute("khachHangList", khachHangService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String saveCreate(@Valid @ModelAttribute("giaoDich") GiaoDich giaoDich, BindingResult bindingResult, Model model) {
        new GiaoDich().validate(giaoDich, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("khachHangList", khachHangService.findAll());
            return "/create";
        } else {
            giaoDichService.save(giaoDich);
            return "redirect:/listGiaoDich";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("giaoDich", giaoDichService.findById(id));
        model.addAttribute("khachHang" , khachHangService.findAll());
        return "/edit";
    }

    @PostMapping("/updateGiaoDich")
    public String update(@ModelAttribute  GiaoDich giaoDich){
        giaoDichService.save(giaoDich);
        return "redirect:/listGiaoDich";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        giaoDichService.delete(id);
        return "redirect:/listGiaoDich";
    }
    @GetMapping("/search")
    public String search(Model model,@RequestParam String loaiGiaoDich,@RequestParam String tenKhachHang){
        model.addAttribute("giaoDichList",this.giaoDichService.search(loaiGiaoDich,tenKhachHang));
                model.addAttribute("khachHangList" , khachHangService.findAll());
        return "list";
    }
}