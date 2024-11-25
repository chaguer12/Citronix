package Citronix.repository;

import Citronix.model.Harvest;
import Citronix.model.enums.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HarvestRepository extends JpaRepository<Harvest, UUID> {
    double countByFieldId(UUID field_id);
    boolean existsBySeasonAndFieldId(Season season,UUID field_id);

}
