package io.group17.travelagencybooking.services;

import java.util.List;

import io.group17.travelagencybooking.dtos.Customerdto;
import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.models.Customer;

public interface CustomerService
{
    Customerdto createCustomer(Customer customer);
    Customerdto getCustomerById(Long id);
    List<Customerdto> getAllCustomers();
    Customerdto updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    List<Booking> getCurrentBookings(Long customerId);
    List<Booking> getPastBookings(Long customerId);
}