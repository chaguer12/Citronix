package Citronix.service.impl;

import Citronix.dto.FarmMapper;
import Citronix.dto.records.FarmRequestDTO;
import Citronix.dto.records.FarmResponseDTO;
import Citronix.exception.EntityNotFoundException;
import Citronix.model.Farm;
import Citronix.repository.FarmRepository;
import Citronix.service.FarmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FarmService implements FarmServiceInterface {
    private final FarmRepository farmRepo;
    private final FarmMapper farmMapper;

    @Override
    public FarmResponseDTO save(FarmRequestDTO farmRequest){
        Farm farm = Farm.builder()
                .name(farmRequest.name())
                .created_at(LocalDateTime.now())
                .location(farmRequest.location())
                .superficie(farmRequest.superficie())
                .build();
        farmRepo.save(farm);
        return farmMapper.toDTO(farm);
    }

    @Override
    public List<FarmResponseDTO> getFarms(){
        List<Farm> farms = farmRepo.findAll();
        return farms.stream().map(farmMapper::toDTO).toList();
    }

    @Override
    public boolean deleteFarm(UUID id) {
        if(farmRepo.existsById(id)){
            farmRepo.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("farm not found with id" + id);
        }

    }

    @Override
    public FarmResponseDTO update(FarmRequestDTO farm) {
        Farm frm = Farm.builder().name(farm.name()).location(farm.location()).superficie(farm.superficie()).build();
        farmRepo.save(frm);
        return farmMapper.toDTO(frm);
    }
}
