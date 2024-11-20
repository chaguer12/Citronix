package Citronix.service;

import Citronix.model.Farm;

import java.util.List;

public interface FarmServiceInterface {
    Farm save(Farm farm);
    List<Farm> getFarms();
}
