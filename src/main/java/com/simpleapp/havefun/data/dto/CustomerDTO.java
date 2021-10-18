package com.simpleapp.havefun.data.dto;

import com.simpleapp.havefun.data.entity.Customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDTO {

    private int id;

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "must have at least 1 character")
    @NotBlank(message = "Not only white spaces")
    private String lastName;

    @NotNull(message = "is required")
    @Email(message = "is not an Email Address")
    private String email;

    public CustomerDTO(int id, String firstName, @NotNull @Size(min = 1) String lastName, @NotNull @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer convertIntoCustomer(){
        return new Customer(id, firstName, lastName, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
