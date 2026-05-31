package ra.hwss0801.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.hwss0801.exception.BookAlreadyReturnedException;
import ra.hwss0801.exception.ResourceNotFoundException;
import ra.hwss0801.model.dto.request.BookCreateDTO;
import ra.hwss0801.model.dto.request.BorrowCreateDTO;
import ra.hwss0801.model.entity.Book;
import ra.hwss0801.model.entity.Borrow;
import ra.hwss0801.model.entity.BorrowStatus;
import ra.hwss0801.repository.BookRepository;
import ra.hwss0801.repository.BorrowRepository;
import ra.hwss0801.service.BorrowService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;

    @Override
    public Borrow createBorrow(BorrowCreateDTO borrowCreateDTO) {
        Borrow borrow = Borrow.builder()
                .username(borrowCreateDTO.getUsername())
                .bookId(borrowCreateDTO.getBookId())
                .build();
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow returnBook(Long ticketId) {
        Borrow borrowTicket = borrowRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu mượn ID " + ticketId));
        if (borrowTicket.getStatus() == BorrowStatus.RETURNED) {
            throw new BookAlreadyReturnedException("Sách đã được trả!");
        }
        borrowTicket.setStatus(BorrowStatus.RETURNED);
        borrowTicket.setReturnDate(LocalDateTime.now());
        Book book = bookRepository.findById(borrowTicket.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sách có ID " + borrowTicket.getBookId()));
        book.setStock(book.getStock() + 1);
        bookRepository.save(book);
        return borrowRepository.save(borrowTicket);
    }
}
