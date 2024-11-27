package Citronix.controller;

import Citronix.dto.records.farm.FarmRequestDTO;
import Citronix.dto.records.farm.FarmResponseDTO;
import Citronix.dto.records.farm.FarmSearchDTO;
import Citronix.dto.records.farm.FarmUpdateDTO;
import Citronix.model.Farm;
import Citronix.service.FarmServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/farm")
@RequiredArgsConstructor
public class FarmController {


    private final FarmServiceInterface farmService;
    @PostMapping
    public ResponseEntity<FarmResponseDTO> createFarm(@Valid @RequestBody FarmRequestDTO farmRequest){
        FarmResponseDTO responseDTO = farmService.save(farmRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping
    public ResponseEntity<List<FarmResponseDTO>> getFarms(){
         List<FarmResponseDTO> farms = farmService.getFarms();
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(farms);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarm(@PathVariable String id){
        farmService.deleteFarm(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmResponseDTO> updateFarm(@PathVariable String id, @Valid @RequestBody FarmUpdateDTO farm){
        FarmResponseDTO responseDTO = farmService.update(UUID.fromString(id),farm);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDTO);
    }

    @PostMapping("/search")
    public ResponseEntity<List<FarmResponseDTO>> searchFarmsByName(@RequestBody FarmSearchDTO farm){
        List<FarmResponseDTO> response =   farmService.searchFarms(farm);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);

    }



}
