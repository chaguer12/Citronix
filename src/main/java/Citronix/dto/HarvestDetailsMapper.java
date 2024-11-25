package Citronix.dto;

import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.harvestDetails.HarvestDetRequestDTO;
import Citronix.dto.records.harvestDetails.HarvestDetResponseDTO;
import Citronix.model.HarvestDetails;
import org.mapstruct.Mapper;

@Mapper(config = GenericMapper.class)
public interface HarvestDetailsMapper extends GenericMapper<HarvestDetails, HarvestDetRequestDTO, HarvestDetResponseDTO> {
}
