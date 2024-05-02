package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.group17.travelagencybooking.utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group17.travelagencybooking.dtos.Customerdto;
import io.group17.travelagencybooking.ExceptionHandler.CustomerException.*;
import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.models.Customer;
import io.group17.travelagencybooking.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customerdto createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return mapToCustomerDto(savedCustomer);
    }

    @Override
    public Customerdto getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return mapToCustomerDto(optionalCustomer.get());
        } else {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
    }

    @Override
    public List<Customerdto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public Customerdto updateCustomer(Customer customer) {
        return mapToCustomerDto(customer);
    }

    @Override
    public Customerdto updateCustomer(Long id, Customerdto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer = mapToCustomer(customerDto);
            Customer updatedCustomer = customerRepository.save(customer);
            return mapToCustomerDto(updatedCustomer);
        } else {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
    }

    private Customerdto mapToCustomerDto(Customer customer) {
        Customerdto customerDto = new Customerdto();
        customerDto.setName(customer.getName());
        customerDto.setContactNumber(customer.getContactNumber());
        customerDto.setEmailId(customer.getEmailId());
        return customerDto;
    }

    private Customer mapToCustomer(Customerdto customerDto)
    {
        Customer customer1 = CustomerUtils.mapToCustomer(customerDto);
        Customer customer = new Customer(customer1.getName(), customer1.getContactNumber(), customer1.getEmailId());
        customer.setName(customerDto.getName());
        customer.setContactNumber(customerDto.getContactNumber());
        customer.setEmailId(customerDto.getEmailId());
        return customer;
    }

    @Override
    public List<Booking> getCurrentBookings(Long customerId) {
        // Should Complete
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentBookings'");
    }

    @Override
    public List<Booking> getPastBookings(Long customerId) {
        // Should Complete
        throw new UnsupportedOperationException("Unimplemented method 'getPastBookings'");
    }
}