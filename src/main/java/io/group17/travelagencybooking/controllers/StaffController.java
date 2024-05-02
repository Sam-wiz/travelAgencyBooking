package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.services.TravelPackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController
{
    private TravelPackageService travelPackageService;

    @GetMapping("/travel-packages")
    public ResponseEntity<List<TravelPackage>> getAllTravelPackages() {

        return null;
    }

    @GetMapping("/travel-packages/{id}")
    public ResponseEntity<TravelPackage> getTravelPackageById(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/travel-packages")
    public ResponseEntity<TravelPackage> createTravelPackage(@RequestBody TravelPackage travelPackage) {
        return null;
    }

    @PutMapping("/travel-packages/{id}")
    public ResponseEntity<TravelPackage> updateTravelPackage(@PathVariable Long id, @RequestBody TravelPackage travelPackage)
    {
        return null;
    }

    @DeleteMapping("/travel-packages/{id}")
    public ResponseEntity<Void> deleteTravelPackage(@PathVariable Long id) {
        return null;
    }
}