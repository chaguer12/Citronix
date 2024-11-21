package Citronix.dto.records.field;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record FieldRequestDTO(
        @NotNull
        @Positive
        long superficie,
        @NotNull
        UUID farm_id
) {
}
