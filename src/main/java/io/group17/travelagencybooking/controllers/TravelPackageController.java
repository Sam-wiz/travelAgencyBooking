package io.group17.travelagencybooking.controllers;
import io.group17.travelagencybooking.dtos.TravelPackagedto;
import io.group17.travelagencybooking.services.TravelPackageService;
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
        return ResponseEntity.ok(travelPackageService.getAllTravelPackagesDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTravelPackageById(@PathVariable Long id) {
        TravelPackagedto TravelPackagedto = travelPackageService.getTravelPackageByIdDto(id);
        if (TravelPackagedto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(TravelPackagedto);
    }

    @PostMapping
    public ResponseEntity<?> createTravelPackage(@RequestBody TravelPackagedto TravelPackagedto) {
        TravelPackagedto createdPackageDto = travelPackageService.createTravelPackagedto(TravelPackagedto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPackageDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTravelPackage(@PathVariable Long id, @RequestBody TravelPackagedto updatedPackageDto) {
        TravelPackagedto updatedDto = travelPackageService.updateTravelPackagedto(id, updatedPackageDto);
        if (updatedDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTravelPackage(@PathVariable Long id) {
        travelPackageService.deleteTravelPackageById(id);
        return ResponseEntity.noContent().build();
    }
}