package Citronix.service;

import Citronix.dto.records.farm.FarmRequestDTO;
import Citronix.dto.records.farm.FarmResponseDTO;

import java.util.List;
import java.util.UUID;

public interface FarmServiceInterface {
    FarmResponseDTO save(FarmRequestDTO farm);
    List<FarmResponseDTO> getFarms();
    boolean deleteFarm(UUID id);
    FarmResponseDTO update(FarmRequestDTO farm);
}
