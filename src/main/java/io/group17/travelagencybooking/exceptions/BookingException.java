package io.group17.travelagencybooking.exceptions;

public class BookingException {

    public static class BookingNotFoundException extends RuntimeException {
        public BookingNotFoundException(String bookingId) {
            super("Booking with ID " + bookingId + " not found");
        }
    }

    // You can define other custom exceptions for booking-related scenarios here
}