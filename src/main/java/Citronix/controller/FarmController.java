package Citronix.controller;

import Citronix.model.Farm;
import Citronix.service.FarmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/farm")
@RequiredArgsConstructor
public class FarmController {

    private final FarmServiceInterface farmService;
    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm){

    }
}
