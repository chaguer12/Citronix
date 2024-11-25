package Citronix.dto;

import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.harvest.HarvestRequestDTO;
import Citronix.dto.records.harvest.HarvestResponseDTO;
import Citronix.model.Harvest;
import org.mapstruct.Mapper;

@Mapper(config = GenericMapper.class)
public interface HarvestMapper extends GenericMapper<Harvest, HarvestRequestDTO, HarvestResponseDTO> {
}
