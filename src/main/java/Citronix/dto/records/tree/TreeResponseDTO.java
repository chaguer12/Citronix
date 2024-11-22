package Citronix.dto.records.tree;

import Citronix.model.Field;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public record TreeResponseDTO(
        @NotNull
        UUID id,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate planted_at
) {
}
