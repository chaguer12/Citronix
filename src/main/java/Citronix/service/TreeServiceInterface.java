package Citronix.service;

import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.dto.records.field.FieldUpdateDTO;
import Citronix.dto.records.tree.TreeRequestDTO;
import Citronix.dto.records.tree.TreeResponseDTO;
import Citronix.dto.records.tree.TreeUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface TreeServiceInterface {
    TreeResponseDTO save(TreeRequestDTO tree);
    List<TreeResponseDTO> getTrees(UUID tree_id);
    boolean deleteTree(UUID id);
    TreeResponseDTO update(UUID id, TreeUpdateDTO tree);
}
