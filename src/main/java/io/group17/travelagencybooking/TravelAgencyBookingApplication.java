package io.group17.travelagencybooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.group17.travelagencybooking")
public class TravelAgencyBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyBookingApplication.class, args);
    }

}
