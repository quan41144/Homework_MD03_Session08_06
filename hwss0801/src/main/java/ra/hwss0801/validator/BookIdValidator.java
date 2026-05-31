package ra.hwss0801.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import ra.hwss0801.repository.BookRepository;

@RequiredArgsConstructor
public class BookIdValidator implements ConstraintValidator<ExistingBookId, Long> {
    private final BookRepository bookRepository;
    @Override
    public boolean isValid(Long bookId, ConstraintValidatorContext context) {
        if (bookId == null) {
            return false;
        }
        return bookRepository.existsById(bookId);
    }
}
