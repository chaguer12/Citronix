package Citronix.service.impl;

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

    @Override
    public Farm save(Farm farm){
        farm.setCreated_at(LocalDateTime.now());
        farmRepo.save(farm);
        return farm;
    }

    @Override
    public List<Farm> getFarms(){
        return farmRepo.findAll();
    }

}
