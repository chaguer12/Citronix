package Citronix.controller;

import Citronix.dto.records.harvest.HarvestRequestDTO;
import Citronix.dto.records.harvest.HarvestResponseDTO;
import Citronix.service.HarvestServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
