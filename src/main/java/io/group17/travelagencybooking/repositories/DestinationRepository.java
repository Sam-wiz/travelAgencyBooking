package io.group17.travelagencybooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import io.group17.travelagencybooking.models.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {}