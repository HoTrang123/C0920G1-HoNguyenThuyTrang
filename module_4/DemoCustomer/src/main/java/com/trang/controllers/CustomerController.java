package com.trang.controllers;

import com.trang.services.ICustomerService;
import com.trang.services.models.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping(value = "/list")
    public ModelAndView getListCustomer(){
        List<CustomerDTO> customerDTOList = this.iCustomerService.getListCustomer();
        return new ModelAndView("list", "customerList", customerDTOList);
    }
}
