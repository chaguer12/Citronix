package Citronix.controller;

import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.dto.records.field.FieldUpdateDTO;
import Citronix.model.Field;
import Citronix.service.FieldServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    @GetMapping("/{id}")
    public ResponseEntity<List<FieldResponseDTO>> getFields(@PathVariable String id){
        List<FieldResponseDTO> fields = fieldService.getFields(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(fields);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteField(@PathVariable String id){
        fieldService.deleteField(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> updateField(@PathVariable String id,@Valid @RequestBody FieldUpdateDTO field){
        FieldResponseDTO responseDTO = fieldService.update(UUID.fromString(id),field);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }


}
