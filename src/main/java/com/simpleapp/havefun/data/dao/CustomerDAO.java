package com.simpleapp.havefun.data.dao;

import com.simpleapp.havefun.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerByEmail(String email);

    Optional<Customer> findCustomerByFirstNameAndAndLastName(String firstName, String lastName);
}
