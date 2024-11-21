package Citronix.service;

import Citronix.dto.records.farm.FarmRequestDTO;
import Citronix.dto.records.farm.FarmResponseDTO;
import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;

import java.util.List;
import java.util.UUID;

public interface FieldServiceInterface {
    FieldResponseDTO save(FieldRequestDTO field);
    List<FieldResponseDTO> getFields(UUID farm_id);
    boolean deleteField(UUID id);
    FieldResponseDTO update(FieldRequestDTO field);

}
