package Citronix.controller;

import Citronix.dto.records.sale.SaleRequestDTO;
import Citronix.dto.records.sale.SaleResponseDTO;
import Citronix.service.SaleServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
