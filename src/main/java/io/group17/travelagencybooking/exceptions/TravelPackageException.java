package io.group17.travelagencybooking.exceptions;

public class TravelPackageException {
    public static class TravelPackageNotFoundException extends RuntimeException {
        public TravelPackageNotFoundException(Long travelPackageId) {
            super("Travel package with ID " + travelPackageId + " not found");
        }
    }

    public static class InvalidTravelPackageException extends RuntimeException {
        public InvalidTravelPackageException(String message) {
            super(message);
        }
    }
}