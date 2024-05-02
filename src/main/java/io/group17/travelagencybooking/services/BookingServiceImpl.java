package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.group17.travelagencybooking.dtos.Bookingdto;
import io.group17.travelagencybooking.exceptions.BookingException.BookingNotFoundException;
import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.repositories.BookingRepository;
import io.group17.travelagencybooking.utils.BookingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Bookingdto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(BookingUtils::mapToBookingDto)
                .collect(Collectors.toList());
    }

    @Override
    public Bookingdto getBookingById(long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            return BookingUtils.mapToBookingDto(optionalBooking.get());
        }
        else
        {
            throw new BookingNotFoundException("Booking not found with ID: " + id);
        }
    }

    @Override
    public Bookingdto createBooking(Bookingdto bookingDto) {
        Booking booking = BookingUtils.mapToBooking(bookingDto);
        Booking savedBooking = bookingRepository.save(booking);
        return BookingUtils.mapToBookingDto(savedBooking);
    }

    @Override
    public Bookingdto updateBooking(long id, Bookingdto updatedBookingDto) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking = BookingUtils.updateBookingFromDto(booking, updatedBookingDto);
            Booking updatedBooking = bookingRepository.save(booking);
            return BookingUtils.mapToBookingDto(updatedBooking);
        } else {
            throw new BookingNotFoundException("Booking not found with ID: " + id);
        }
    }

    @Override
    public void deleteBooking(long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            bookingRepository.deleteById(id);
        } else {
            throw new BookingNotFoundException("Booking not found with ID: " + id);
        }
    }

    @Override
    public List<Bookingdto> getAllBookingsByCustomerId(Long customerId) {
        List<Booking> bookings = bookingRepository.findByCustomerId(customerId);
        return bookings.stream()
                .map(BookingUtils::mapToBookingDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Bookingdto> getAllBookingsByPackageId(Long packageId) {
        List<Booking> bookings = bookingRepository.findByTravelPackageId(packageId);
        return bookings.stream()
                .map(BookingUtils::mapToBookingDto)
                .collect(Collectors.toList());
    }
}