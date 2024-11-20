package Citronix.dto.records;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record FarmRequestDTO(
        @NotNull
        @Size(min = 10, max = 100)
        String name,
        LocalDateTime created_at,
        @NotNull(message = "Location cannot be null")
        @Size(max = 255)
        String location,

        @NotNull
        @Min(value = 1, message = "Value must be >= 1")
        long superficie
) {
}
