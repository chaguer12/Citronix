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
@Table(name = "trees")
public class Tree {
    @Id
    private UUID id;
    @NotNull
    private LocalDate planted;
    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    @ManyToOne
    @JoinColumn(name = "details_id")
    private HarvestDetails details;



    public Tree(){

    }

}
