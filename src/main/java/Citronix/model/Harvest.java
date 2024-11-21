package Citronix.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "harvests")
public class Harvest {
    @Id
    private UUID id;
    private LocalDate created_at;
    @NotNull
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "details_id")
    private HarvestDetails details;


    public Harvest(){

    }
}