package Citronix.repository;

import Citronix.model.Farm;
import Citronix.repository.custom.FarmSearchRepo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface FarmRepository  extends JpaRepository<Farm, UUID>, FarmSearchRepo {

}
