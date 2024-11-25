package Citronix.service.impl;

import Citronix.dto.HarvestMapper;
import Citronix.dto.records.harvest.HarvestRequestDTO;
import Citronix.dto.records.harvest.HarvestResponseDTO;
import Citronix.dto.records.harvest.HarvestUpdateDTO;
import Citronix.exception.EntityNotFoundException;
import Citronix.exception.HarvestMadeBefore;
import Citronix.exception.ValidationException;
import Citronix.model.Field;
import Citronix.model.Harvest;
import Citronix.model.HarvestDetails;
import Citronix.model.Tree;
import Citronix.model.enums.Season;
import Citronix.repository.FieldRepository;
import Citronix.repository.HarvestDetailsRepository;
import Citronix.repository.HarvestRepository;
import Citronix.repository.TreeRepository;
import Citronix.service.HarvestDetailsInterface;
import Citronix.service.HarvestServiceInterface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class HarvestService implements HarvestServiceInterface {
    private final HarvestMapper harvestMapper;
    private final HarvestRepository harvestRepo;
    private final FieldRepository fieldRepository;
    private final TreeRepository treeRepository;
    private final HarvestDetailsRepository harvestDetRepo;

    @Override

    public HarvestResponseDTO save(HarvestRequestDTO harvest) {
        Field field = fieldRepository.findById(harvest.field_id()).orElseThrow(() -> new EntityNotFoundException("entity not found"));
        double harvest_count = harvestRepo.countByFieldId(harvest.field_id());
        List<Tree> trees = treeRepository.getTreesByFieldId(field.getId());
        System.out.println("here ->: "+ harvest_count);
        String season = getSeasonForDate(harvest.created_at());
        Harvest hrvst = null;
        if(season.equals("winter") && harvest_count < 4  && !harvestRepo.existsBySeasonAndFieldId(Season.WINTER,field.getId())){
             hrvst = Harvest.builder().season(Season.WINTER).created_at(harvest.created_at()).field(field).build();
        } else if (season.equals("spring") && harvest_count < 4  && !harvestRepo.existsBySeasonAndFieldId(Season.SPRING,field.getId())) {
             hrvst = Harvest.builder().season(Season.SPRING).created_at(harvest.created_at()).field(field).build();
        } else if (season.equals("summer") && harvest_count < 4  && !harvestRepo.existsBySeasonAndFieldId(Season.SUMMER,field.getId())) {
             hrvst = Harvest.builder().season(Season.SUMMER).created_at(harvest.created_at()).field(field).build();
        } else if (season.equals("fall") && harvest_count < 4  && !harvestRepo.existsBySeasonAndFieldId(Season.FALL,field.getId())) {
             hrvst = Harvest.builder().season(Season.FALL).created_at(harvest.created_at()).field(field).build();
        }else{
            throw new HarvestMadeBefore("harvest made before");
        }
        double totalQTY =0;
        HarvestDetails details = null;
        for(Tree tree : trees){
            details = new HarvestDetails();
            details.setHarvest(hrvst);
            details.setTree(tree);
            double quantity = calculateTreeProd(tree.getPlanted_at());
            details.setQuantity(quantity);
            totalQTY += quantity;
        }
        hrvst.setQuantity(totalQTY);
        harvestRepo.save(hrvst);
        harvestDetRepo.save(details);
        return harvestMapper.toDTO(hrvst);
    }

    @Override
    public List<HarvestResponseDTO> getHarvests(UUID field_id) {
        return List.of();
    }

    @Override
    public boolean deleteHarvest(UUID id) {
        return false;
    }

    @Override
    public HarvestResponseDTO update(UUID id, HarvestUpdateDTO harvest) {
        return null;
    }

    private String getSeasonForDate(LocalDate date) {
        int month = date.getMonthValue();
        if (month >= 1 && month <= 3) {
            return "winter";
        } else if (month >= 4 && month <= 6) {
            return "spring";
        } else if (month >= 7 && month <= 9) {
            return "summer";
        } else if (month >= 10 && month <= 12) {
            return "fall";
        }
        throw new ValidationException("Date must be Valid");
    }

    private double calculateTreeProd(LocalDate planted_at){
        LocalDate now = LocalDate.now();
        double age = Period.between(planted_at,now).getYears();
        if(age<3){
            return 2.5 * 4;
        } else if (age <= 10) {
            return 12 * 4;
            
        }else{
            return 20 * 4;
        }
    }

}
