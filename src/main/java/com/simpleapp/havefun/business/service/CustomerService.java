package com.simpleapp.havefun.business.service;

import com.simpleapp.havefun.data.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stephane, Nganou Wafo
 *
 * This class provide methods enforcing certain requirements for Customers.
 */

@Service
public interface CustomerService {

    /**
     * Retrieve Data from the Database via CustomerDTO.
     * @return a List of Customers
     */
    List<Customer> getCustomerList();

    /**
     * saves a Customer object into the Database.
     * @param theCustomer
     */
    void saveCustomer(Customer theCustomer);
}
