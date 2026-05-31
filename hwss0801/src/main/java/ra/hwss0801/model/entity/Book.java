package ra.hwss0801.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 200)
    private String title;
    @Column(name = "author", length = 100)
    private String author;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "cover_url", nullable = false, unique = true)
    private String coverUrl;
}
