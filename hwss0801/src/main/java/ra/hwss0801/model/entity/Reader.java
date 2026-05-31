package ra.hwss0801.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "readers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, unique = true, nullable = false)
    private String email;
    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(name ="phone_number", length = 100)
    private String phoneNumber;
    @Column(length = 100)
    private String address;
    @Column(length = 500)
    private String avatar;
}
