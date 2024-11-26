package Citronix.service;

import Citronix.dto.records.sale.SaleRequestDTO;
import Citronix.dto.records.sale.SaleResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SaleServiceInterface {
    SaleResponseDTO save(SaleRequestDTO sale);
    List<SaleResponseDTO> getSales();
    boolean delete(UUID id);
}
