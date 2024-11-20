package Citronix.service;

import Citronix.dto.records.FarmRequestDTO;
import Citronix.dto.records.FarmResponseDTO;
import Citronix.model.Farm;

import java.util.List;

public interface FarmServiceInterface {
    FarmResponseDTO save(FarmRequestDTO farm);
    List<Farm> getFarms();
}
