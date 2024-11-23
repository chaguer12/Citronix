package Citronix.controller;

import Citronix.dto.records.tree.TreeRequestDTO;
import Citronix.dto.records.tree.TreeResponseDTO;
import Citronix.model.Tree;
import Citronix.service.TreeServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tree")
@RequiredArgsConstructor
public class TreeController {
    private final TreeServiceInterface treeService;

    @PostMapping
    public ResponseEntity<TreeResponseDTO> save(@Valid @RequestBody TreeRequestDTO tree){
        TreeResponseDTO response = treeService.save(tree);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{field_id}")
    public ResponseEntity<List<TreeResponseDTO>> getTrees(@PathVariable String field_id){
        List<TreeResponseDTO> trees = treeService.getTrees(UUID.fromString(field_id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(trees);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTree(@PathVariable String id){
        treeService.deleteTree(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted successfully!");
    }
}
