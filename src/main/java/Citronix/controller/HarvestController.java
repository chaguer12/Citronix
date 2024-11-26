package Citronix.controller;

import Citronix.dto.records.harvest.HarvestRequestDTO;
import Citronix.dto.records.harvest.HarvestResponseDTO;
import Citronix.service.HarvestServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/harvest")
public class HarvestController {

    private final HarvestServiceInterface harvestService;

    @PostMapping
    public ResponseEntity<HarvestResponseDTO> savHarvest(@Valid @RequestBody HarvestRequestDTO harvestDTO){
        HarvestResponseDTO response = harvestService.save(harvestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{field_id}")
    public ResponseEntity<List<HarvestResponseDTO>> getHarvests(@PathVariable String field_id){
        List<HarvestResponseDTO> response = harvestService.getHarvests(UUID.fromString(field_id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHarvest(@PathVariable String id){
        harvestService.deleteHarvest(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("harvest deleted successfully");
    }
}
