package Citronix.service;

import Citronix.dto.records.harvestDetails.HarvestDetRequestDTO;
import Citronix.dto.records.harvestDetails.HarvestDetResponseDTO;

public interface HarvestDetailsInterface {
    HarvestDetResponseDTO save(HarvestDetRequestDTO detailsDTO);

}
