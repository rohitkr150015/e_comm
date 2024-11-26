package endtimelines.worker_customer.Entity;


import endtimelines.worker_customer.Enums.Profession;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id", nullable = false)
private User user;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
private Profession profession; // e.g., Plumber, Electrician


    @Size(max = 500)
    private String skills;  // e.g., "Pipe Fitting, Electrical Wiring"

    @Size(max =100)
private String bio;

    @NotNull
    @DecimalMin(value="0.0", inclusive = false)
private Double hourlyRate;


@NotBlank
private String location;

@NotNull
private Boolean available; //whether the worker is availbale for hire

    @OneToOne(mappedBy = "worker" , cascade = CascadeType.ALL)
    private WorkerProfile workerProfile; //Link to WorkerProfile entity
}
