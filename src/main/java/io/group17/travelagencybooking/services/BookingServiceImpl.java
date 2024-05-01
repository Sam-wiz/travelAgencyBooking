package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.repositories.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
     @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        return optionalBooking.orElse(null);
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(long id, Booking updatedBooking) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setCustomer(updatedBooking.getCustomer());
            booking.setTravelPackage(updatedBooking.getTravelPackage());
            booking.setBookingDate(updatedBooking.getBookingDate());
            booking.setNumberOfTravelers(updatedBooking.getNumberOfTravelers());
            booking.setTotalCost(updatedBooking.getTotalCost());
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void deleteBooking(long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> getAllBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Booking> getAllBookingsByPackageId(Long packageId) {
        return bookingRepository.findByTravelByPackageId(packageId);
    }
}
