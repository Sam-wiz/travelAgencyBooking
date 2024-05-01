package io.group17.travelagencybooking.services;

import java.util.List;

import io.group17.travelagencybooking.dtos.Bookingdto;
public interface BookingService
{
    List<Bookingdto> getAllBookings();
    Bookingdto getBookingById(long id);
    Bookingdto createBooking(Bookingdto booking);
    Bookingdto updateBooking(long id, Bookingdto updatedBooking);
    void deleteBooking(long id);
    List<Bookingdto> getAllBookingsByCustomerId(Long customerId);
    List<Bookingdto> getAllBookingsByPackageId(Long travelPackageId);
}