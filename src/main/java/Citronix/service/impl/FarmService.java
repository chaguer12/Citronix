package Citronix.service.impl;

import Citronix.model.Farm;
import Citronix.repository.FarmRepository;
import Citronix.service.FarmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmService implements FarmServiceInterface {
    private final FarmRepository farmRepo;

    @Override
    public Farm save(Farm farm){
        farmRepo.save(farm);
        return farm;
    }

}
