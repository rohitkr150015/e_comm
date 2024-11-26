package endtimelines.worker_customer.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @NotBlank
    @Size(max = 200, message = "Address can have at most 200 characters.")
    private String address;

    @NotBlank
    @Size(max = 50, message = "City name can have at most 50 characters.")
    private String city;

    @NotBlank
    @Size(max = 50, message = "State name can have at most 50 characters.")
    private String state;

    @NotBlank
    @Size(max = 10, message = "Invalid ZIP code.")
    private String zipCode;

    @Size(max = 200, message = "Additional details can have at most 200 characters.")
    private String additionalDetails;


}
