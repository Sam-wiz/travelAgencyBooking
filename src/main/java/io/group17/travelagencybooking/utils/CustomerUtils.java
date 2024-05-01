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
}