package com.simpleapp.havefun.web;

import com.simpleapp.havefun.business.service.CustomerService;
import com.simpleapp.havefun.data.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        log.info("rendering customer list");

        // get customers from DAO
        List<Customer> theCustomers = customerService.getCustomerList();

        // add the customers to the model;
        theModel.addAttribute("customerList", theCustomers);

        return "list-customers";
    }
}
