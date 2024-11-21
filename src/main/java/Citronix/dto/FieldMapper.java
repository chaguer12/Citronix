package Citronix.dto;

import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.model.Field;
import org.mapstruct.Mapper;

@Mapper(config = GenericMapper.class)
public interface FieldMapper extends GenericMapper <Field, FieldRequestDTO, FieldResponseDTO>{
}
