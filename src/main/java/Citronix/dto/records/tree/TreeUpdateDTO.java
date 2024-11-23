package Citronix.dto.records.tree;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record TreeUpdateDTO(
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate planted_at
) {
}
