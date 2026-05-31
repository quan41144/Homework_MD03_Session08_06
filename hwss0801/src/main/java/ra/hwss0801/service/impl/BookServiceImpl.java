package ra.hwss0801.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.hwss0801.exception.ResourceNotFoundException;
import ra.hwss0801.model.dto.request.BookCreateDTO;
import ra.hwss0801.model.dto.request.BookUpdateStockDTO;
import ra.hwss0801.model.entity.Book;
import ra.hwss0801.repository.BookRepository;
import ra.hwss0801.service.BookService;

import java.io.File;
import java.io.IOException;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final String UPLOAD_DIR = System.getProperty("user.dir") + "src/main/resources/uploads/";
    @Override
    public Book createBook(BookCreateDTO bookCreateDTO) {
        String coverUrl = null;
        MultipartFile coverImage = bookCreateDTO.getCoverImage();
        if (coverImage != null && !coverImage.isEmpty()) {
            coverUrl = uploadLocal(coverImage);
        }
        Book book = Book.builder()
                .title(bookCreateDTO.getTitle())
                .author(bookCreateDTO.getAuthor())
                .stock(bookCreateDTO.getStock())
                .coverUrl(coverUrl)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, BookUpdateStockDTO bookUpdateStockDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sách có ID " + id));
        book.setStock(bookUpdateStockDTO.getStock());
        return bookRepository.save(book);
    }

    private String uploadLocal(MultipartFile imageFile) {
        String fileName = imageFile.getOriginalFilename();
        File parent = new File(UPLOAD_DIR);
        File destination = new File(UPLOAD_DIR + "/" + fileName);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try {
            imageFile.transferTo(destination);
        }
        catch (IOException e) {
            throw new RuntimeException("Không thể lưu file: " + e.getMessage());
        }
        return "src\\main\\resources\\uploads\\" + fileName;
    }
}
