package ra.hwss0801.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.hwss0801.model.dto.request.BorrowCreateDTO;
import ra.hwss0801.model.entity.Borrow;
import ra.hwss0801.repository.BorrowRepository;
import ra.hwss0801.service.BorrowService;

@RestController
@RequestMapping("/api/borrows")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;

    @PostMapping
    public ResponseEntity<Borrow> createBorrow(@Valid @RequestBody BorrowCreateDTO borrowCreateDTO) {
        Borrow borrow = borrowService.createBorrow(borrowCreateDTO);
        return new ResponseEntity<>(borrow, HttpStatus.CREATED);
    }
    @PatchMapping("/{id}/return")
    public ResponseEntity<Borrow> updateBorrow(@PathVariable Long id) {
        Borrow borrow = borrowService.returnBook(id);
        return new ResponseEntity<>(borrow, HttpStatus.OK);
    }
}
