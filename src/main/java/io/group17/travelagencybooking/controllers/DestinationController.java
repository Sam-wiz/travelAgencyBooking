package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.models.TravelPackage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destinations")
public class DestinationController {
    @GetMapping("/{id}")
    public Destination getDestinationById(Long id){
        return null;
    }
    @PutMapping("/{id}")
    public Destination updateDestinationById(@RequestBody Destination destination) {
        return null;
    }
    @PostMapping("")
    public Destination createDestination(@RequestBody Destination destination){
        return null;
    }
    @DeleteMapping("/{id}")
    public Destination removeDestinationById(@PathVariable Long id) {
        return null;
    }
}
