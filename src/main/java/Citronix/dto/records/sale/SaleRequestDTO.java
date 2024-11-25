package Citronix.dto.records.sale;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SaleRequestDTO(
        @NotNull
        double qty,
        @NotNull
        double price,
        @NotBlank
        String client_name,
        @NotNull
        UUID harvest_id
) {
}
