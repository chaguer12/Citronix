package Citronix.repository.custom;

import Citronix.dto.records.farm.FarmSearchDTO;
import Citronix.model.Farm;

import java.util.List;

public interface FarmSearchRepo {
    List<Farm> searchFarms(FarmSearchDTO criteria);
}
