package Citronix.repository;

import Citronix.dto.records.tree.TreeResponseDTO;
import Citronix.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TreeRepository extends JpaRepository<Tree, UUID> {
    double countByFieldId(UUID id);
    List<Tree> getTreesByFieldId(UUID field_id);
}
