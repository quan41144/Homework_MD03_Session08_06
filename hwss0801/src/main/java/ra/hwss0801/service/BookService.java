package ra.hwss0801.service;

import ra.hwss0801.model.dto.request.BookCreateDTO;
import ra.hwss0801.model.dto.request.BookUpdateStockDTO;
import ra.hwss0801.model.entity.Book;

public interface BookService {
    Book createBook(BookCreateDTO bookCreateDTO);
    Book updateBook(Long id, BookUpdateStockDTO bookUpdateStockDTO);
}
