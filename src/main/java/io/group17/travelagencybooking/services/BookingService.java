package io.group17.travelagencybooking.services;

import java.util.List;
import io.group17.travelagencybooking.models.Booking;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(long id);
    Booking createBooking(Booking booking);
    Booking updateBooking(long id, Booking updatedBooking);
    void deleteBooking(long id);
    List<Booking> getAllBookingsByCustomerId(Long customerId);
    List<Booking> getAllBookingsByPackageId(Long travelPackageId);
}