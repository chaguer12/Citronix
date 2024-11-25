package Citronix.dto.records.harvest;

import Citronix.dto.records.field.FieldEmbededDTO;
import Citronix.model.Field;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record HarvestEmbedeDTO(

        UUID id,
        LocalDate created_at,
        FieldEmbededDTO field
) {
}
