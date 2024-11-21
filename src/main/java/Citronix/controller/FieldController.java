package Citronix.controller;

import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.service.FieldServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/field")
@RequiredArgsConstructor
public class FieldController {
    private final FieldServiceInterface fieldService;

    @PostMapping
    public ResponseEntity<FieldResponseDTO> assignField(@Valid @RequestBody FieldRequestDTO field){
        FieldResponseDTO responseDTO = fieldService.save(field);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
