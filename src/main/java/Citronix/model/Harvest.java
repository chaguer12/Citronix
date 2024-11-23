package Citronix.model;

import Citronix.model.enums.Season;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "harvests")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate created_at;
    @NotNull
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "details_id")
    private HarvestDetails details;
    @NotNull
    private Season season;
    @ManyToOne
    @JoinColumn(name = "field_id")
    @NotNull
    private Field field;


    public Harvest(){

    }
}
