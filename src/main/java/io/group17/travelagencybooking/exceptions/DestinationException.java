package io.group17.travelagencybooking.exceptions;

public class DestinationException {

    public static class DestinationNotFoundException extends RuntimeException {
        public DestinationNotFoundException(Long destinationId) {
            super("Destination with ID " + destinationId + " not found");
        }
    }

    public static class InvalidDestinationException extends RuntimeException {
        public InvalidDestinationException(String message) {
            super(message);
        }
    }
}