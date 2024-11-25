package Citronix.dto.records.field;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FieldEmbededDTO(
        UUID id,
        double superficie
) {
}
