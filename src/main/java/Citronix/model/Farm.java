package Citronix.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Getter
@AllArgsConstructor
@Builder
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "Name cannot be null")
    @Size(min=10,max = 100)
    private String name;
    private LocalDateTime created_at;
    @NotNull
    private String location;
    @NotNull
    @Min(value = 1, message = "(value must be >= 1)")
    private long superficie;

    public Farm(){

    }



}
