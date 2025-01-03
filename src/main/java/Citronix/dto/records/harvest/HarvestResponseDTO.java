package Citronix.dto.records.harvest;

import Citronix.model.Field;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record HarvestResponseDTO(
        @NotNull
        UUID id,
        LocalDate created_at,
        Field field
) {
}
