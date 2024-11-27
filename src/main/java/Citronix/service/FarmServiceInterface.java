package Citronix.service;

import Citronix.dto.records.farm.FarmRequestDTO;
import Citronix.dto.records.farm.FarmResponseDTO;
import Citronix.dto.records.farm.FarmSearchDTO;
import Citronix.dto.records.farm.FarmUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface FarmServiceInterface {
    FarmResponseDTO save(FarmRequestDTO farm);
    List<FarmResponseDTO> getFarms();
    boolean deleteFarm(UUID id);
    FarmResponseDTO update(UUID id,FarmUpdateDTO farm);

    List<FarmResponseDTO> searchFarms(FarmSearchDTO criteria);
}
