package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.models.Booking;
import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.services.BookingService;
import io.group17.travelagencybooking.services.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationController {
    private DestinationController destinationController;
    private DestinationService destinationService;

    //Create a new destination

    @PostMapping("")
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination){
        Destination createdDestination = destinationService.createDestination(destination);
        return new ResponseEntity<>(createdDestination, HttpStatus.CREATED);
//        return null;
    }
    //Get all destinations
    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations(){
        List<Destination> destinations = destinationService.getAllDestinations();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }
    //Get a destination by Id
    @GetMapping("/{destinationId}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Long destinationId){
        Destination destination = destinationService.getDestinationById(destinationId);
        return new ResponseEntity<>(destination, HttpStatus.OK);
//        return null;

    }
    //Update a destination by Id
    @PutMapping("/{destinationId}")
    public ResponseEntity<Destination> updateDestinationById(@PathVariable Long destinationId, @RequestBody Destination destination) {
        Destination updatedDestination = destinationService.updateDestination(destinationId, destination);
        return new ResponseEntity<>(updatedDestination, HttpStatus.OK);
//        return null;
    }
    //Delete a destination
    @DeleteMapping("/{destinationId}")
    public ResponseEntity<Void> removeDestinationById(@PathVariable Long destinationId) {
        destinationService.deleteDestination(destinationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        return null;
    }
}
