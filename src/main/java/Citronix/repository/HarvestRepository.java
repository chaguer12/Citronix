package Citronix.repository;

import Citronix.model.Harvest;
import Citronix.model.enums.Season;
import Citronix.repository.custom.FarmSearchRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HarvestRepository extends JpaRepository<Harvest, UUID>{
    double countByFieldId(UUID field_id);
    boolean existsBySeasonAndFieldId(Season season,UUID field_id);
    List<Harvest> findByFieldId(UUID id);

}
