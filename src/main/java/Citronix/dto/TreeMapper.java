package Citronix.dto;

import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.tree.TreeRequestDTO;
import Citronix.dto.records.tree.TreeResponseDTO;
import Citronix.model.Tree;
import org.mapstruct.Mapper;

@Mapper(config = GenericMapper.class)
public interface TreeMapper extends GenericMapper<Tree, TreeRequestDTO, TreeResponseDTO> {
}
