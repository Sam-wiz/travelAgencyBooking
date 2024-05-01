package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group17.travelagencybooking.dtos.Customerdto;
import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.models.Customer;
import io.group17.travelagencybooking.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customerdto createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return mapToCustomerDto(savedCustomer);
    }

    @Override
    public Customerdto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer != null ? mapToCustomerDto(customer) : null;
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
        Customer updatedCustomer = customerRepository.save(customer);
        return mapToCustomerDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private Customerdto mapToCustomerDto(Customer customer) {
        Customerdto customerDto = new Customerdto();
        customerDto.setName(customer.getName());
        customerDto.setContactNumber(customer.getContactNumber());
        customerDto.setEmailId(customer.getEmailId());
        return customerDto;
    }

    @Override
    public List<Booking> getCurrentBookings(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentBookings'");
    }

    @Override
    public List<Booking> getPastBookings(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPastBookings'");
    }
    
}
