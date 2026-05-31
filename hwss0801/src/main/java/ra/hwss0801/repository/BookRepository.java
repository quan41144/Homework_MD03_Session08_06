package ra.hwss0801.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.hwss0801.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
