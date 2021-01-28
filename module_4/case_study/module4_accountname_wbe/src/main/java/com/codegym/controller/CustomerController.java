package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.TypeCustomer;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/customer"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"","/"})
    public String list(Model model, RedirectAttributes redirectAttributes, @PageableDefault(size = 3) Pageable pageable,
                       @RequestParam(required = false) Optional<String> nameSearch){
       String search = "";
       if (nameSearch.isPresent()){
           search = nameSearch.get();
           model.addAttribute("customerList", customerService.findByNameContaining(pageable, search));
//           model.addAttribute("nameSearch", search);
       } else {
           model.addAttribute("customerList", customerService.findAll(pageable));
       }
//        redirectAttributes.addFlashAttribute("message", "");

        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        List<TypeCustomer> typeCustomerList = customerService.findAllTypeCustomer();
        model.addAttribute("typeCustomerList", typeCustomerList);
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute(value = "customer") Customer customer, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model){
        boolean check = false;
        List<Customer> customerList = customerService.findAll();
        for (Customer customer1 : customerList){
            if (customer1.getId().equals(customer.getId())){
                check = true;
                break;
            }
        }

        if (bindingResult.hasFieldErrors() || check){
            model.addAttribute("typeCustomerList", customerService.findAllTypeCustomer());
            if (!bindingResult.hasFieldErrors()){
                model.addAttribute("message", "This ID already exits");
            }
            return "customer/create";
        }

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create Successfully");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model){
        model.addAttribute("view", customerService.findById(id));
        return "customer/view";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable String id, Model model){
        model.addAttribute("typeCustomerList", customerService.findAllTypeCustomer());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }
    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute(value = "customer") Customer customer, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("typeCustomerList", customerService.findAllTypeCustomer());
            return "customer/edit";
        }
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/customer";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable String id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";

    }

    @PostMapping("delete")
    public String remove(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/customer";
    }


}
