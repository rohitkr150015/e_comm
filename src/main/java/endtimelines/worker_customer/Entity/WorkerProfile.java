package endtimelines.worker_customer.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name="worker_id" , nullable = false)
    private Worker worker;

    private String additionalInfo;

    @OneToMany(mappedBy = "worker")
    private List<JobApplication> jobApplications; //Link to JobListing
}
