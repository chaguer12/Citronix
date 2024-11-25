package Citronix.dto.records.harvest;

import Citronix.model.Field;
import Citronix.model.enums.Season;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public record HarvestRequestDTO(
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate created_at,
        @NotNull
        UUID field_id


) {
}
