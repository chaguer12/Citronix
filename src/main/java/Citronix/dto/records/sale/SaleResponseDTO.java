package Citronix.dto.records.sale;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SaleResponseDTO(

        UUID id,

        double qty,

        double price,

        String client_name,

        UUID harvest_id
) {
}
