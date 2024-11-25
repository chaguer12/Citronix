package Citronix.service;

import Citronix.dto.records.harvest.HarvestRequestDTO;
import Citronix.dto.records.harvest.HarvestResponseDTO;
import Citronix.dto.records.harvest.HarvestUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface HarvestServiceInterface {
    HarvestResponseDTO save(HarvestRequestDTO harvest);
    List<HarvestResponseDTO> getHarvests(UUID field_id);
    boolean deleteHarvest(UUID id);
    HarvestResponseDTO update(UUID id, HarvestUpdateDTO harvest);

}
