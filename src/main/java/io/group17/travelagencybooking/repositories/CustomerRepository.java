package io.group17.travelagencybooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.group17.travelagencybooking.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}