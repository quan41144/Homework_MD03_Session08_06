package ra.hwss0801.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.hwss0801.model.dto.request.BookCreateDTO;
import ra.hwss0801.model.dto.request.BookUpdateStockDTO;
import ra.hwss0801.model.entity.Book;
import ra.hwss0801.service.BookService;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping
    public ResponseEntity<Book> createBook(@ModelAttribute BookCreateDTO bookCreateDTO) {
        Book book = bookService.createBook(bookCreateDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookUpdateStockDTO bookUpdateStockDTO) {
        Book book = bookService.updateBook(id, bookUpdateStockDTO);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
