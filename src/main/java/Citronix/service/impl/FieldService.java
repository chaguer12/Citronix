package Citronix.service.impl;

import Citronix.dto.FieldMapper;
import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.exception.EntityNotFoundException;
import Citronix.model.Farm;
import Citronix.model.Field;
import Citronix.repository.FarmRepository;
import Citronix.repository.FieldRepository;
import Citronix.service.FarmServiceInterface;
import Citronix.service.FieldServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class FieldService implements FieldServiceInterface {

    private final FieldRepository fieldRepo;
    private final FarmRepository farmRepo;
    private final FieldMapper fieldMapper;
    @Override
    public FieldResponseDTO save(FieldRequestDTO field) {
        Farm farm = farmRepo.findById(field.farm_id()).orElseThrow(() -> new EntityNotFoundException("entity not found"));
        long farm_sup = farm.getSuperficie();
        System.out.println(farm_sup + "<- here");
        Field fld = Field.builder().superficie(field.superficie()).farm(farm).build();
        if(farmRepo.existsById(field.farm_id()) && farm.getSuperficie()/2 >= fld.getSuperficie()){
            fieldRepo.save(fld);
        }
        return fieldMapper.toDTO(fld);
    }

    @Override
    public List<FieldResponseDTO> getFields() {
        return List.of();
    }

    @Override
    public boolean deleteField(UUID id) {
        return false;
    }

    @Override
    public FieldResponseDTO update(FieldRequestDTO field) {
        return null;
    }
}
