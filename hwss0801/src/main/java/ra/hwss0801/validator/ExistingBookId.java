package ra.hwss0801.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BookIdValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistingBookId {
    String message() default "Sách không tồn tại trong hệ thống";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
