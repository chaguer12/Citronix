package Citronix.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@AllArgsConstructor
@Entity
@Builder
@Table(name = "fields")
public class Field {
    @Id
    private UUID id;
    @NotNull
    private long superficie;
    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    public Field(){

    }



}
