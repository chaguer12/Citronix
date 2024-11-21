package Citronix.service.impl;

import Citronix.dto.FieldMapper;
import Citronix.dto.records.field.FieldRequestDTO;
import Citronix.dto.records.field.FieldResponseDTO;
import Citronix.exception.EntityNotFoundException;
import Citronix.exception.ValidationException;
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
        long fieldMinSup = farm_sup/2;
        long max = fieldRepo.countByFarmId(farm.getId());
        System.out.println(max + "<- here");
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
        fields.forEach(f -> System.out.println("hna: " + f.getId()));
        return fields.stream().map(fieldMapper::toDTO).toList();
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
