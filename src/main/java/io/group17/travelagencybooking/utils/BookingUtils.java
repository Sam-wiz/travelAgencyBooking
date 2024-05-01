package io.group17.travelagencybooking.utils;

import io.group17.travelagencybooking.dtos.Bookingdto;
import io.group17.travelagencybooking.models.Booking;

public class BookingUtils
{
    public static Bookingdto mapToBookingDto(Booking booking) {
        Bookingdto bookingDto = new Bookingdto();
        bookingDto.setNumberOfTravelers(booking.getNumberOfTravelers());
        bookingDto.setTotalCost(booking.getTotalCost());
        bookingDto.setBookingDate(booking.getBookingDate());
        bookingDto.setCustomerdto(CustomerUtils.mapToCustomerDto(booking.getCustomer()));
        bookingDto.setTravelPackagedto(TravelPackageUtils.mapToTravelPackageDto(booking.getTravelPackage()));
        return bookingDto;
    }

    public static Booking mapToBooking(Bookingdto bookingDto) {
        Booking booking = new Booking();
        booking.setNumberOfTravelers(bookingDto.getNumberOfTravelers());
        booking.setTotalCost(bookingDto.getTotalCost());
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setCustomer(CustomerUtils.mapToCustomer(bookingDto.getCustomerdto()));
        booking.setTravelPackage(TravelPackageUtils.mapToTravelPackage(bookingDto.getTravelPackagedto()));
        return booking;
    }

    public static Booking updateBookingFromDto(Booking booking, Bookingdto updatedBookingDto) {
        return booking;
    }
}