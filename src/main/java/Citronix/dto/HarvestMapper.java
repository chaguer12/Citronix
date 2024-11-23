package Citronix.dto;

import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.harvest.HarvestRequestDTO;
import Citronix.dto.records.harvest.HarvestResponseDTO;
import Citronix.model.Harvest;

public interface HarvestMapper extends GenericMapper<Harvest, HarvestRequestDTO, HarvestResponseDTO> {
}
