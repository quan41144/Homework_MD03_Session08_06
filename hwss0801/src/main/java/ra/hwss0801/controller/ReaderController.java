package ra.hwss0801.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.hwss0801.model.dto.request.ReaderCreateDTO;
import ra.hwss0801.model.entity.Reader;
import ra.hwss0801.service.ReaderService;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    @PostMapping
    public ResponseEntity<Reader> createReader(@Valid @ModelAttribute ReaderCreateDTO readerCreateDTO) {
        Reader reader = readerService.createReader(readerCreateDTO);
        return new ResponseEntity<>(reader, HttpStatus.CREATED);
    }
}
