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

import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.services.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    @GetMapping
    public ResponseEntity<?> getAllTravelPackages() {
        return ResponseEntity.ok(travelPackageService.getAllTravelPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTravelPackageById(@PathVariable Long id) {
        TravelPackage travelPackage = travelPackageService.getTravelPackageById(id);
        if (travelPackage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(travelPackage);
    }

    @PostMapping
    public ResponseEntity<?> createTravelPackage(@RequestBody TravelPackage travelPackage) {
        TravelPackage createdPackage = travelPackageService.createTravelPackage(travelPackage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPackage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTravelPackage(@PathVariable Long id, @RequestBody TravelPackage updatedPackage) {
        TravelPackage updated = travelPackageService.updateTravelPackage(id, updatedPackage);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTravelPackage(@PathVariable Long id) {
        travelPackageService.deleteTravelPackage(id);
        return ResponseEntity.noContent().build();
    }
}