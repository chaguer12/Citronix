package Citronix.repository;

import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FieldRepository extends JpaRepository<Field, UUID> {
    double countByFarmId(UUID id);
    List<Field> findByFarmId(UUID farmId);
}
