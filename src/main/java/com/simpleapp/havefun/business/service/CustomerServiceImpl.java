package com.simpleapp.havefun.business.service;

import com.simpleapp.havefun.data.dao.CustomerDAO;
import com.simpleapp.havefun.data.dto.CustomerDTO;
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
    public List<CustomerDTO> getCustomerList() {

        return customerDAO.findAll(Sort.by("lastName"))
                .stream().map(Customer::convertIntoDto)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public List<CustomerDTO> searchCustomers(String searchName) {
        return StreamSupport
                .stream(customerDAO.findAllByLastNameOrderByLastName(searchName).spliterator(), false)
                .map(Customer::convertIntoDto)
                .collect(Collectors.toList());
    }

    /**
     * @see CustomerService#saveCustomer(CustomerDTO)
     */
    @Override
    @Transactional
    public void saveCustomer(CustomerDTO theCustomerDTO) {
        if (theCustomerDTO != null) {
            customerDAO.save(theCustomerDTO.convertIntoCustomer());
        }
    }

    /**
     * @see CustomerService#getCustomerById(int)
     */
    @Override
    @Transactional
    public CustomerDTO getCustomerById(int customerId) {
        Customer foundCustomer = customerDAO.getById(customerId);

        return (foundCustomer != null) ? foundCustomer.convertIntoDto() : null;

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
