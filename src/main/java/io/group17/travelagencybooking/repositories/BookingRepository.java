package io.group17.travelagencybooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.group17.travelagencybooking.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {}