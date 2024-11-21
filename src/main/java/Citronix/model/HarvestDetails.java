package Citronix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Entity
@Table
@AllArgsConstructor
public class HarvestDetails {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;
    @ManyToOne
    @JoinColumn(name = "tree_id")
    private Tree tree;
    private long quantity;



    public HarvestDetails(){

    }
}
