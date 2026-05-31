package ra.hwss0801.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ra.hwss0801.exception.BookAlreadyReturnedException;
import ra.hwss0801.exception.InvalidImageException;
import ra.hwss0801.exception.ResourceNotFoundException;
import ra.hwss0801.model.dto.response.ErrorResponse;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BookAlreadyReturnedException.class)
    public ResponseEntity<ErrorResponse> handleBookAlreadyReturnedException(BookAlreadyReturnedException ex) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidImageException.class)
    public ResponseEntity<ErrorResponse> handleInvalidImageException(InvalidImageException ex) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }
}
