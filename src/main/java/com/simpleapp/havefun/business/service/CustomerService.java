package com.simpleapp.havefun.business.service;

import com.simpleapp.havefun.data.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stephane, Nganou Wafo
 * This class provide methods enforcing certain requirements for Customers.
 */

@Service
public interface CustomerService {

    /**
     * Retrieve Data from the Database via CustomerDTO.
     *
     * @return a List of Customers
     */
    List<Customer> getCustomerList();

    /**
     * Search customers based upon their lastNames
     */
    List<Customer> searchCustomers(String searchName);

    /**
     * saves a Customer object into the Database.
     */
    void saveCustomer(Customer theCustomer);

    /**
     * search and retrieve a customer by his Id.
     */
    Customer getCustomerById(int customerId);

    /**
     * method used to delete a specific customer using his Id.
     */
    void deleteCustomer(int customerId);
}
