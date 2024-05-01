package io.group17.travelagencybooking.services;

import io.group17.travelagencybooking.dtos.Customerdto;
import io.group17.travelagencybooking.models.Customer;

import java.util.List;

public interface CustomerService
{
    Customerdto createCustomer(Customer customer);
    Customerdto getCustomerById(Long id);
    List<Customerdto> getAllCustomers();
    Customerdto updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}