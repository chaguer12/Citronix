package Citronix.controller;

import Citronix.model.Farm;
import Citronix.service.FarmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/farm")
@RequiredArgsConstructor
public class FarmController {

    private final FarmServiceInterface farmService;
    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm){
        Farm frm = farmService.save(farm);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(frm);
    }
    @GetMapping
    public ResponseEntity<List<Farm>> getFarms(){
         List<Farm> frms = farmService.getFarms();
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(frms);
    }


}
