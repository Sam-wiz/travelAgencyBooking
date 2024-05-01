package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.services.DestinationService;
import io.group17.travelagencybooking.services.DestinationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class DestinationControllerTest {
    @Autowired
    private DestinationController destinationController;

    @MockBean
    private DestinationService destinationService;

    @Test
    void getDestinationById() {
//        Destination destination = new Destination();
//
//        destination.setId(1l);
//        destination.setName("Bangalore");
//        destination.setLocationDescription("Silicon Valley of India");
////        destination.setPopularAttractions("Bangalore Palace");
//
//        when(destinationService.getDestinationById(1L))
//                .thenReturn(destination);
//
//        System.out.println(destination.getPopularAttractions()); // null
//
//        Destination outputDestination = destinationController.getDestinationById(1L);
//
//        assertEquals(destination, outputDestination);

    }

    @Test
    void updateDestinationById() {
    }

    @Test
    void createDestination() {
    }

    @Test
    void removeDestinationById() {
    }
}