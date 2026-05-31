package ra.hwss0801.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookCreateDTO {
    @NotBlank(message = "Không được để trống title!")
    private String title;
    @NotBlank(message = "Không được để trống author!")
    private String author;
    @NotNull(message = "Không được để trống stock!")
    @Min(value = 0, message = "Số lượng tồn kho không được âm!")
    private Integer stock;
    private MultipartFile coverImage;
}
