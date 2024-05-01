package io.group17.travelagencybooking.services;

import io.group17.travelagencybooking.controllers.BookingController;
import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.models.Destination;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookingServiceTest {
    private BookingService bookingService;
    private BookingController bookingController;
    @Test
    void getBookingById() {
        Booking booking = new Booking();

        booking.setId(1L);
        booking.setNumberOfTravelers(100);
        booking.setTotalCost(10000.0);
        booking.setBookingDate("01/05/2024");

        when(bookingService.getBookingById(1L))
                .thenReturn(booking);

        ResponseEntity<?> outputBooking = bookingController.getBookingById(1L);

        assertEquals(booking, outputBooking);
    }

    @Test
    void createBooking() {
    }

    @Test
    void updateBooking() {
    }

    @Test
    void deleteBooking() {
    }
}