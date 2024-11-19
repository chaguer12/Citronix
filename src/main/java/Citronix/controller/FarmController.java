package Citronix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/farm")
public class FarmController {
    @GetMapping
    public String test(){
        return "hello";
    }
}
