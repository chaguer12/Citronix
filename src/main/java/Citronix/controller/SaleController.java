package Citronix.controller;

import Citronix.dto.records.sale.SaleRequestDTO;
import Citronix.dto.records.sale.SaleResponseDTO;
import Citronix.service.SaleServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sale")
public class SaleController {

    private final SaleServiceInterface saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> saveSale(@Valid @RequestBody SaleRequestDTO saleReq){
        SaleResponseDTO response =saleService.save(saleReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getSales(){
        List<SaleResponseDTO> response = saleService.getSales();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateSale(@PathVariable String id){
        saleService.delete(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("sale deleted successfully");
    }
}
