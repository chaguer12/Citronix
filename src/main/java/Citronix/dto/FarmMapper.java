package Citronix.dto;

import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.FarmRequestDTO;
import Citronix.dto.records.FarmResponseDTO;
import Citronix.model.Farm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper extends GenericMapper<Farm, FarmRequestDTO, FarmResponseDTO> {




}
