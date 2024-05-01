package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.dtos.Customerdto;
import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.models.Customer;
import io.group17.travelagencybooking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customerdto> createCustomer(@RequestBody Customer customer) {
        Customerdto createdCustomerDto = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customerdto> getCustomerById(@PathVariable Long id) {
        Customerdto customerDto = customerService.getCustomerById(id);
        return customerDto != null
                ? ResponseEntity.ok(customerDto)
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Customerdto>> getAllCustomers() {
        List<Customerdto> customerDtos = customerService.getAllCustomers();
        return ResponseEntity.ok(customerDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customerdto> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        updatedCustomer.setId(id);
        Customerdto updatedCustomerDto = customerService.updateCustomer(updatedCustomer);
        return ResponseEntity.ok(updatedCustomerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{customerId}/current-bookings")
    public ResponseEntity<List<Booking>> getCurrentBookings(@PathVariable Long customerId) {
        List<Booking> currentBookings = customerService.getCurrentBookings(customerId);
        return ResponseEntity.ok(currentBookings);
    }

    @GetMapping("/{customerId}/past-bookings")
    public ResponseEntity<List<Booking>> getPastBookings(@PathVariable Long customerId) {
        List<Booking> pastBookings = customerService.getPastBookings(customerId);
        return ResponseEntity.ok(pastBookings);
    }
}