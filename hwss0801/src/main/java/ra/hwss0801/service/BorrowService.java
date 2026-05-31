package ra.hwss0801.service;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import ra.hwss0801.model.dto.request.BookCreateDTO;
import ra.hwss0801.model.dto.request.BorrowCreateDTO;
import ra.hwss0801.model.entity.Borrow;

public interface BorrowService {
    Borrow createBorrow(BorrowCreateDTO borrowCreateDTO);
    Borrow returnBook(Long ticketId);
}
