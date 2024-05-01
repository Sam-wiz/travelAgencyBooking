package io.group17.travelagencybooking.utils;

import io.group17.travelagencybooking.dtos.Bookingdto;
import io.group17.travelagencybooking.models.Booking;

public class BookingUtils {
    public static Bookingdto mapToBookingDto(Booking booking) {
        Bookingdto bookingDto = new Bookingdto();
        bookingDto.setNumberOfTravelers(booking.getNumberOfTravelers());
        bookingDto.setTotalCost(booking.getTotalCost());
        bookingDto.setBookingDate(booking.getBookingDate());
        bookingDto.setCustomerdto(CustomerUtils.mapToCustomerDto(booking.getCustomer()));
        bookingDto.setTravelPackagedto(TravelPackageUtils.mapToTravelPackageDto(booking.getTravelPackage()));
        return bookingDto;
    }
}