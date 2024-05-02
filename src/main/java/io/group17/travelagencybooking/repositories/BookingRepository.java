package io.group17.travelagencybooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import io.group17.travelagencybooking.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long customerId);
    List<Booking> findByTravelPackageId(Long packageId);
}