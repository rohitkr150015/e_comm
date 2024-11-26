package endtimelines.worker_customer.Entity;

import endtimelines.worker_customer.Enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer; // The customer who posted the job

    private String title;

    @Column(nullable = false)
    private String description;

    private String location;

    @Column(nullable = false)
    private Double budget;

    private LocalDateTime postedAt;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;


    private Boolean active; // Whether the job is still open
}
