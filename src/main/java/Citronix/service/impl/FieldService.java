package Citronix.service.impl;

import Citronix.dto.FieldMapper;
import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.dto.records.field.FieldUpdateDTO;
import Citronix.exception.EntityNotFoundException;
import Citronix.exception.ValidationException;
import Citronix.model.Farm;
import Citronix.model.Field;
import Citronix.repository.FarmRepository;
import Citronix.repository.FieldRepository;
import Citronix.service.FieldServiceInterface;
import jakarta.transaction.Transactional;
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
        double farm_sup = farm.getSuperficie();
        double fieldMinSup = farm_sup/2;
        double max = fieldRepo.countByFarmId(farm.getId());
        Field fld = Field.builder().superficie(field.superficie()).farm(farm).build();
        if(fieldMinSup >= fld.getSuperficie() && max <10){
            fieldRepo.save(fld);
        }else{
            throw new ValidationException("Superficie must be insufisant");
        }
        return fieldMapper.toDTO(fld);
    }

    @Override
    public List<FieldResponseDTO> getFields(UUID farm_id) {
        List<Field> fields = fieldRepo.findByFarmId(farm_id);
        return fields.stream().map(fieldMapper::toDTO).toList();
    }

    @Override
    public boolean deleteField(UUID id) {
        if(fieldRepo.existsById(id)){
            fieldRepo.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("farm not found with id" + id);
        }
    }

    @Override
    @Transactional
    public FieldResponseDTO update(UUID id, FieldUpdateDTO fieldDTO) {
        Field field = fieldRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
        if(fieldDTO.superficie() != field.getSuperficie()){
            field.setSuperficie(fieldDTO.superficie());
            fieldRepo.save(field);
        }
        return fieldMapper.toDTO(field);

    }
}
