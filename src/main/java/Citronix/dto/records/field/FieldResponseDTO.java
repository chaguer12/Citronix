package Citronix.dto.records.field;


import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FieldResponseDTO(
        @NotNull
        UUID id,
        @NotNull
        long superficie
) {

}
