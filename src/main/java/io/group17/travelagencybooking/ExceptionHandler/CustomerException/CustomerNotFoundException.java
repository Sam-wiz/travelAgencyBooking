package io.group17.travelagencybooking.ExceptionHandler.CustomerException;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}