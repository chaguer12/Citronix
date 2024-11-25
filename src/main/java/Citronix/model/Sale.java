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
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double qty;
    private double price;
    private String client_name;
    @OneToOne
    @JoinColumn(name = "harvest_id",referencedColumnName = "id")
    private Harvest harvest;

    public Sale(){

    }

}
