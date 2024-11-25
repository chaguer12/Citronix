package Citronix.repository;

import Citronix.model.HarvestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HarvestDetailsRepository extends JpaRepository<HarvestDetails, UUID> {
}
