package Citronix.dto.records.farm;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record FarmResponseDTO(
        @NotNull
        UUID id,
        @NotNull
        @Size(min = 10, max = 100)
        String name,
        LocalDateTime created_at,
        @NotNull(message = "Location cannot be null")
        @Size(max = 255)
        String location,

        @NotNull
        @Min(value = 1, message = "Value must be >= 1")
        double superficie
) {
}
