package com.simpleapp.havefun.web;

import com.simpleapp.havefun.business.service.CustomerService;
import com.simpleapp.havefun.data.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stephane Nganou Wafo
 * Controller to handle anything related to customer
 */
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
    public String listCustomers(Model customerModel) {
        log.info("rendering customer list");

        // get customers from DAO
        List<Customer> theCustomers = customerService.getCustomerList();

        // add the customers to the model;
        customerModel.addAttribute("customerList", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddCustomer(Model customerModel) {
        log.info("rendering the customer-form page");

        Customer theCustomer = new Customer();
        customerModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/showFormForUpdate/{customerId}")
    public String showFormForUpdateCustomer(@PathVariable(value = "customerId") int theCustomerId,
                                            Model theCustomerModel) {

        log.info("rendering info on customer with id: {}", theCustomerId);

        // Get the customer from the database
        Customer foundCustomer = customerService.getCustomerById(theCustomerId);

        // set customer as a model attribute to pre-populate the form
        theCustomerModel.addAttribute("customer", foundCustomer);

        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable(value = "customerId") int theCustomerId) {
        log.info("deleting the customer with id: {}", theCustomerId);

        customerService.deleteCustomer(theCustomerId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("theSearchName") String theSearchName,
                                 Model customerModel) {

        log.info("searching for customer with lastName: {}", theSearchName);

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        // add the customers to the model
        customerModel.addAttribute("customerList", theCustomers);

        return "list-customers";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        log.info("saving the customer: {}", theCustomer);

        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
}
