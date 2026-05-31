package ra.hwss0801.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ra.hwss0801.validator.ExistingBookId;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class BorrowCreateDTO {
    @NotBlank(message = "Không được để trống tên người dùng!")
    private String username;
    @NotNull(message = "Không được để trống mã sách!")
    @ExistingBookId
    private Long bookId;
}
