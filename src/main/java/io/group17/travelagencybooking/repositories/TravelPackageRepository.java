package io.group17.travelagencybooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import io.group17.travelagencybooking.models.TravelPackage;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
    List<TravelPackage> findByDestinationId(Long destinationId);
}