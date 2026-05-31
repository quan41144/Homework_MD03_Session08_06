package ra.hwss0801.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReaderCreateDTO {
    @NotBlank(message = "Không được để trống email!")
    @Email(message = "Không đúng định dạng email!")
    private String email;
    @NotBlank(message = "Không được để trống tên!")
    private String fullName;
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Số điện thoại không đúng định dạng!")
    private String phoneNumber;
    @NotBlank(message = "Không được để trống địa chỉ!")
    private String address;
    private MultipartFile avatarFile;
}
