package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.models.TravelPackage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packages")
public class TravelPackageController {

    @GetMapping("/{id}")
    public TravelPackage getPackageById(Long id){
        return null;
    }
    @PutMapping("/{id}")
    public TravelPackage updateVehicleById(@RequestBody TravelPackage travelPackage) {
        return null;
    }
    @PostMapping("")
    public TravelPackage createPackage(@RequestBody TravelPackage travelPackage){
        return null;
    }
    @DeleteMapping("/{id}")
    public TravelPackage removePackageById(@PathVariable Long id) {
        return null;
    }
}
