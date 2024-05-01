package io.group17.travelagencybooking.controllers;
import io.group17.travelagencybooking.models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id)
    {
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer)
    {
        return null;
    }
}
