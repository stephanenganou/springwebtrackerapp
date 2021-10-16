package com.simpleapp.havefun.business.service;

import com.simpleapp.havefun.data.dao.CustomerDAO;
import com.simpleapp.havefun.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        return customerDAO.findAll(Sort.by("firstName"));
    }

    /**
     * @see CustomerService#saveCustomer(Customer)
     */
    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.save(theCustomer);
    }
}
