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

        return customerDAO.findAll(Sort.by("lastName"));
    }

    /**
     * @see CustomerService#saveCustomer(Customer)
     */
    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {

        //Customer existingCustomer = getCustomerById(theCustomer.getId());
        //if(null != existingCustomer){
            //customerDAO.sa
        //}
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

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {

        customerDAO.deleteById(customerId);
    }
}
