package io.group17.travelagencybooking.exceptions;



public class UserException {
    public static class CustomerNotFoundException extends RuntimeException {
        public CustomerNotFoundException(Long customerId) {
            super("Customer with ID " + customerId + " not found");
        }
    }

    public static class InvalidCustomerException extends RuntimeException {
        public InvalidCustomerException(String message) {
            super(message);
        }
    }
}