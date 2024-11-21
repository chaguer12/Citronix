package Citronix.dto.records.farm;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record FarmUpdateDTO (

        @Size(min = 10, max = 100)
        String name,
        LocalDateTime created_at,
        @Size(max = 255)
        String location,
        @Min(value = 1, message = "Value must be >= 1")
        long superficie
){
}
