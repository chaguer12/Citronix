package Citronix.dto.records.tree;

import Citronix.model.Field;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record TreeRequestDTO(
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate planted_at,
        @NotNull
        Field field


) {
}
