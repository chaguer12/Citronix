package Citronix.service.impl;

import Citronix.dto.records.harvestDetails.HarvestDetRequestDTO;
import Citronix.dto.records.harvestDetails.HarvestDetResponseDTO;
import Citronix.repository.HarvestDetailsRepository;
import Citronix.service.HarvestDetailsInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HarvestDeatailsService implements HarvestDetailsInterface {
    private final HarvestDetailsRepository detailsRepo;

    @Override
    public HarvestDetResponseDTO save(HarvestDetRequestDTO detailsDTO) {
        return null;
    }
}
