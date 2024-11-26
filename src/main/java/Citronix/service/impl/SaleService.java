package Citronix.service.impl;

import Citronix.dto.SaleMapper;
import Citronix.dto.records.sale.SaleRequestDTO;
import Citronix.dto.records.sale.SaleResponseDTO;
import Citronix.model.Harvest;
import Citronix.model.Sale;
import Citronix.repository.FieldRepository;
import Citronix.repository.HarvestRepository;
import Citronix.repository.SaleRepository;
import Citronix.service.SaleServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleService implements SaleServiceInterface {

    private final SaleRepository saleRepo;
    private final HarvestRepository harvestRepository;
    private final SaleMapper saleMapper;

    @Override
    public SaleResponseDTO save(SaleRequestDTO sale) {
        Harvest harvest = harvestRepository.findById(sale.harvest_id()).orElseThrow(()-> new EntityNotFoundException("not found"));
        System.out.println("here -> :"+harvest.getQuantity());
        Sale new_sale = Sale.builder()
                .qty(harvest.getQuantity())
                .price(sale.price())
                .client_name(sale.client_name())
                .harvest(harvest).build();
        saleRepo.save(new_sale);
        return saleMapper.toDTO(new_sale);
    }

    @Override
    public List<SaleResponseDTO> getSales() {
        List<Sale> sales = saleRepo.findAll();
        return sales.stream().map(saleMapper::toDTO).toList();
    }

    @Override
    public boolean delete(UUID id) {
        if(saleRepo.existsById(id)){
            saleRepo.deleteById(id);
            return true;
        }else {
            throw new EntityNotFoundException("not found");
        }
    }
}
