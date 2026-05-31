package ra.hwss0801.exception;

import org.springframework.validation.FieldError;

public class MethodArgumentNotValidException extends RuntimeException {
    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
