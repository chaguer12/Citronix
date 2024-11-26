package Citronix.dto;

import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.sale.SaleRequestDTO;
import Citronix.dto.records.sale.SaleResponseDTO;
import Citronix.model.Sale;
import org.mapstruct.Mapper;

@Mapper(config = GenericMapper.class)
public interface SaleMapper extends GenericMapper<Sale, SaleRequestDTO, SaleResponseDTO> {
}
