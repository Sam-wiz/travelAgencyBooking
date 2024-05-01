package io.group17.travelagencybooking.ExceptionHandler.BookingException;

public class BookingNotFoundException extends RuntimeException
{
    public BookingNotFoundException(String message) {
        super(message);
    }
}
