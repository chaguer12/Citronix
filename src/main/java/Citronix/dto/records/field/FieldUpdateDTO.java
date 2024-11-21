package Citronix.dto.records.field;

import jakarta.validation.constraints.NotNull;

public record FieldUpdateDTO(
        @NotNull
        long superficie
) {
}
