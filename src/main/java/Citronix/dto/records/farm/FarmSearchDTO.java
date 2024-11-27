package Citronix.dto.records.farm;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record FarmSearchDTO(
        String name,
        LocalDateTime created_at,
        @Size(max = 255)
        String location,
        double superficie
) {
}
