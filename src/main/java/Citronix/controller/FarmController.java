package Citronix.controller;

import Citronix.dto.FarmMapper;
import Citronix.dto.mapper.GenericMapper;
import Citronix.dto.records.FarmRequestDTO;
import Citronix.dto.records.FarmResponseDTO;
import Citronix.model.Farm;
import Citronix.service.FarmServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
    public ResponseEntity<List<Farm>> getFarms(){
         List<Farm> frms = farmService.getFarms();
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(frms);
    }


}
