package ra.hwss0801.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class BookUpdateStockDTO {
    @NotNull(message = "Không được để trống số lượng tồn kho!")
    @Min(value = 0, message = "Không được để số lượng tồn kho là số âm!")
    private Integer stock;
}
