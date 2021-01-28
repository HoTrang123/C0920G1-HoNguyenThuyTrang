package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.TypeCustomer;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.model.user.User;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.user.UserService;
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
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    @GetMapping(value = {"","/"})
    public String list(Model model, RedirectAttributes redirectAttributes, @PageableDefault(size = 3) Pageable pageable,
                       @RequestParam(required = false) Optional<String> nameSearch){
        String search = "";
        if (nameSearch.isPresent()){
            search = nameSearch.get();
            model.addAttribute("employeeList", employeeService.findByNameContaining(pageable, search));
        } else {
            model.addAttribute("employeeList", employeeService.findAll(pageable));
        }
        return "employee/list";

    }

    @GetMapping("/create")
    public String create(Model model){
        List<Division> divisionList = employeeService.findAllDivision();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Position> positionList = employeeService.findAllPosition();


        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("positionList", positionList);


        model.addAttribute("employee", new Employee());
        return "employee/create";
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model){

        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeList", this.employeeService.findAll());

            List<Division> divisionList = this.employeeService.findAllDivision();
            model.addAttribute("divisionList", divisionList);

            List<EducationDegree> educationDegreeList = this.employeeService.findAllEducationDegree();
            model.addAttribute("educationDegreeList", educationDegreeList);

            List<Position> positionList = this.employeeService.findAllPosition();
            model.addAttribute("positionList", positionList);

            return "employee/create";
        }

        User user = userService.findByUserName(employee.getUser().getUsername());
        employee.setUser(user);

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Create Successfully");
        return "redirect:/employee";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("view", employeeService.findById(id));
        return "employee/view";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Employee employee = employeeService.findById(id);
        List<Division> divisionList = employeeService.findAllDivision();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Position> positionList = employeeService.findAllPosition();

        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("employeeList", this.employeeService.findAll());

            List<Division> divisionList = this.employeeService.findAllDivision();
            model.addAttribute("divisionList", divisionList);

            List<EducationDegree> educationDegreeList = this.employeeService.findAllEducationDegree();
            model.addAttribute("educationDegreeList", educationDegreeList);

            List<Position> positionList = this.employeeService.findAllPosition();
            model.addAttribute("positionList", positionList);
            return "customer/edit";
        }
        User user = userService.findByUserName(employee.getUser().getUsername());
        employee.setUser(user);

        employeeService.update(employee);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/employee";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/delete";

    }

    @PostMapping("delete")
    public String remove(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.remove(employee.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/employee";
    }


}
