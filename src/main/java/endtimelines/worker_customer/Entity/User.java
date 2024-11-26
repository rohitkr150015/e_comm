package endtimelines.worker_customer.Entity;

import endtimelines.worker_customer.Enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Index;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_user")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        @Index(name="ix_user_email") //add index annotation
        @Email
        @NotBlank
        private String email;

        @Column(nullable = false)
        @NotBlank


        @Size(min = 8)
        private String password;

        @Enumerated(EnumType.STRING)
        private UserRole role; // e.g., WORKER, CUSTOMER

        @NotBlank
        @Size(max = 100)
        private String name;
@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid Phone Number")
        private String phone;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
private Worker worker;


@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
private Customer customer;
    }

