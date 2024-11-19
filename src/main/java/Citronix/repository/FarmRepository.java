package Citronix.repository;

import Citronix.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FarmRepository  extends JpaRepository<Farm, UUID> {

}
