package Citronix.controller;

import Citronix.dto.records.tree.TreeRequestDTO;
import Citronix.dto.records.tree.TreeResponseDTO;
import Citronix.service.TreeServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
