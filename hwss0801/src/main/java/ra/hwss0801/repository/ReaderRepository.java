package ra.hwss0801.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.hwss0801.model.entity.Reader;
@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Boolean existsByEmail(String email);
}
