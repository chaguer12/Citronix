package Citronix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table
@AllArgsConstructor
public class HarvestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;
    @ManyToOne
    @JoinColumn(name = "tree_id")
    private Tree tree;
    private double quantity;



    public HarvestDetails(){

    }
}
