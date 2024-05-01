package io.group17.travelagencybooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.services.DestinationService;

@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public ResponseEntity<?> getAllDestinations() {
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDestinationById(@PathVariable Long id) {
        Destination destination = destinationService.getDestinationById(id);
        if (destination == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destination);
    }

    @PostMapping
    public ResponseEntity<?> createDestination(@RequestBody Destination destination) {
        Destination createdDestination = destinationService.createDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDestination);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDestination(@PathVariable Long id, @RequestBody Destination updatedDestination) {
        Destination updated = destinationService.updateDestination(id, updatedDestination);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.noContent().build();
    }
}
