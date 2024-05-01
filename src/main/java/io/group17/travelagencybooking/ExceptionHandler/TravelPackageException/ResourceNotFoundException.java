package io.group17.travelagencybooking.ExceptionHandler.TravelPackageException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
