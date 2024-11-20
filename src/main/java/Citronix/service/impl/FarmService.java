package Citronix.service.impl;

import Citronix.dto.FarmMapper;
import Citronix.dto.records.FarmRequestDTO;
import Citronix.dto.records.FarmResponseDTO;
import Citronix.model.Farm;
import Citronix.repository.FarmRepository;
import Citronix.service.FarmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public List<Farm> getFarms(){
        return farmRepo.findAll();
    }

}
