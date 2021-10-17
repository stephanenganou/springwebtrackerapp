package com.simpleapp.havefun.business.service;

import com.simpleapp.havefun.data.dao.CustomerDAO;
import com.simpleapp.havefun.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Stephane Nganou Wafo
 * @see CustomerService
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * @see CustomerService#getCustomerList()
     */
    @Override
    @Transactional
    public List<Customer> getCustomerList() {

        return customerDAO.findAll(Sort.by("lastName"));
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchName) {
        return StreamSupport
                .stream(customerDAO.findAllByLastNameOrderByLastName(searchName).spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * @see CustomerService#saveCustomer(Customer)
     */
    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.save(theCustomer);
    }

    /**
     * @see CustomerService#getCustomerById(int)
     */
    @Override
    @Transactional
    public Customer getCustomerById(int customerId) {
        return customerDAO.getById(customerId);
    }

    /**
     * @see CustomerService#deleteCustomer(int)
     */
    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerDAO.deleteById(customerId);
    }
}
