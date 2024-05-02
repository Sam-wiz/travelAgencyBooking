package io.group17.travelagencybooking.utils;

import io.group17.travelagencybooking.dtos.Customerdto;
import io.group17.travelagencybooking.models.Customer;

public class CustomerUtils {
    public static Customerdto mapToCustomerDto(Customer customer) {
        Customerdto customerDto = new Customerdto();
        customerDto.setName(customer.getName());
        customerDto.setContactNumber(customer.getContactNumber());
        customerDto.setEmailId(customer.getEmailId());
        return customerDto;
    }

    public static Customer mapToCustomer(Customerdto customerDto)
    {

        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setContactNumber(customerDto.getContactNumber());
        customer.setEmailId(customerDto.getEmailId());
        return customer;
    }
}