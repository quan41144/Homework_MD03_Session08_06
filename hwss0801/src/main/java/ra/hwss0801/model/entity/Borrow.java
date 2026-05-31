package ra.hwss0801.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrows")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(name = "book_id", nullable = false)
    private Long bookId;
    @Column(name = "status", nullable = false)
    @Builder.Default
    private BorrowStatus status = BorrowStatus.BORROWING;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
}
