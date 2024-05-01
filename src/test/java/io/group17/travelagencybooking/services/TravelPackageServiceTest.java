package io.group17.travelagencybooking.services;

import io.group17.travelagencybooking.controllers.TravelPackageController;
import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.models.TravelPackage;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TravelPackageServiceTest {
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

        ResponseEntity<?> outputTravelPackage = travelPackageController.getTravelPackageById(1L);

        assertEquals(travelPackage, outputTravelPackage);
    }

    @Test
    void createTravelPackage() {
        TravelPackage travelPackage = new TravelPackage();

        travelPackage.setTitle("Bangalore");
        travelPackage.setDescription("Silicon Valley of India");
        travelPackage.setPrice(10000L);
        travelPackage.setDuration(3);

        TravelPackage outputTravelPackage = travelPackageService.createTravelPackage(travelPackage);
        assertEquals(travelPackage, outputTravelPackage);
    }

    @Test
    void updateTravelPackage() {
        TravelPackage travelPackage = new TravelPackage();

        travelPackage.setTitle("Bangalore");
        travelPackage.setDescription("Silicon Valley of India");
        travelPackage.setPrice(10000L);
        travelPackage.setDuration(3);

        TravelPackage outputTravelPackage = travelPackageService.updateTravelPackage(1878L, travelPackage);
        assertEquals(travelPackage, outputTravelPackage);
    }

    @Test
    void deleteTravelPackage() {
        TravelPackage travelPackage = new TravelPackage();

        travelPackage.setTitle("Bangalore");
        travelPackage.setDescription("Silicon Valley of India");
        travelPackage.setPrice(10000L);
        travelPackage.setDuration(3);

        TravelPackage travelPackage1 = travelPackageService.createTravelPackage(travelPackage);
        travelPackageService.deleteTravelPackage(1878L);
        assertEquals(null, travelPackageService.getTravelPackageById(1878L));
    }
}