package endtimelines.worker_customer.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker", nullable = false)
    private WorkerProfile worker ;//Link to WorkerProfile

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobListing job;

    private String coverLetter;

    private LocalDateTime appliedAt;

    private String status; // e.g., PENDING, APPROVED, REJECTED
}
