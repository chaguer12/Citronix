package Citronix.service.impl;

import Citronix.dto.TreeMapper;
import Citronix.dto.records.tree.TreeRequestDTO;
import Citronix.dto.records.tree.TreeResponseDTO;
import Citronix.dto.records.tree.TreeUpdateDTO;
import Citronix.exception.EntityNotFoundException;
import Citronix.exception.ValidationException;
import Citronix.model.Field;
import Citronix.model.Tree;
import Citronix.repository.FieldRepository;
import Citronix.repository.TreeRepository;
import Citronix.service.TreeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class TreeService implements TreeServiceInterface {

    private final TreeRepository treeRepo;
    private final FieldRepository fieldRepo;
    private final TreeMapper treeMapper;
    @Override
    public TreeResponseDTO save(TreeRequestDTO tree) {
        Field field = fieldRepo.findById(tree.field_id()).orElseThrow(()-> new EntityNotFoundException("not found"));
        LocalDate planted_at = tree.planted_at();
        LocalDate start = LocalDate.of(planted_at.getYear(), 3, 1);
        LocalDate end = LocalDate.of(planted_at.getYear(), 5, 31);
        double sup = field.getSuperficie()*10000;
        double density = sup/100;
        double tree_count = treeRepo.countByFieldId(tree.field_id());
        Tree tre = Tree.builder().planted_at(tree.planted_at()).field(field).build();
        if(tree.planted_at().isBefore(end) && tree.planted_at().isAfter(start) && tree_count < density ){
            treeRepo.save(tre);

        }else{
            throw new ValidationException("planted at is not in the allowed range or max trees has been reached or date is not in interval");
        }
        return treeMapper.toDTO(tre);


    }

    @Override
    public List<TreeResponseDTO> getTrees(UUID field_id) {
        List<Tree> response = treeRepo.getTreesByFieldId(field_id);
        return response.stream().map(treeMapper::toDTO).toList();
    }

    @Override
    public boolean deleteTree(UUID id) {
        if(treeRepo.existsById(id)){
            treeRepo.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("farm not found with id" + id);
        }
    }

    @Override
    public TreeResponseDTO update(UUID id, TreeUpdateDTO tree) {
        return null;
    }
}
