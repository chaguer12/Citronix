package Citronix.service;

import Citronix.dto.records.FarmRequestDTO;
import Citronix.dto.records.FarmResponseDTO;
import Citronix.model.Farm;

import java.util.List;
import java.util.UUID;

public interface FarmServiceInterface {
    FarmResponseDTO save(FarmRequestDTO farm);
    List<FarmResponseDTO> getFarms();
    boolean deleteFarm(UUID id);
}
