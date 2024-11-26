package Citronix.service;

import Citronix.dto.records.sale.SaleRequestDTO;
import Citronix.dto.records.sale.SaleResponseDTO;

public interface SaleServiceInterface {
    SaleResponseDTO save(SaleRequestDTO sale);
}
