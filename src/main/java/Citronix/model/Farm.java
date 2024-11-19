package Citronix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class Farm {
    @Id
    private UUID id;
    private String name;
    private LocalDateTime created_at;
    private String location;
    private long superficie;
    

}
