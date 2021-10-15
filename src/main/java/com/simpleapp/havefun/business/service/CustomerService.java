package com.simpleapp.havefun.business.service;

import com.simpleapp.havefun.data.dao.CustomerDAO;
import com.simpleapp.havefun.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getCustomerList() {

        return customerDAO.findAll();
    }
}
