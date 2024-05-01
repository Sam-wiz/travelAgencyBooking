package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.services.TravelPackageService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TravelPackageControllerTest {
    private TravelPackageController travelPackageController;
    private TravelPackageService travelPackageService;
    @Test
    void getAllTravelPackages() {
    }

    @Test
    void getTravelPackageById() {
        TravelPackage travelPackage = new TravelPackage();

        travelPackage.setTitle("Bangalore");
        travelPackage.setDescription("Silicon Valley of India");
        travelPackage.setPrice(100000.0);
        travelPackage.setDuration(3);

        when(travelPackageService.getTravelPackageById(1L))
                .thenReturn(travelPackage);

        ResponseEntity<> outputTravelPackage = travelPackageController.getTravelPackageById(1L);

        assertEquals(travelPackage, outputTravelPackage);
    }

    @Test
    void createTravelPackage() {
    }

    @Test
    void updateTravelPackage() {
    }

    @Test
    void deleteTravelPackage() {
    }
}