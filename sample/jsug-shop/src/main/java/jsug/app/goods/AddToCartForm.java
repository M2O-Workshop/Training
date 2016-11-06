package jsug.app.goods;

import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddToCartForm {
    @NotNull
    private UUID goodsId;
    @NotNull
    @Min(1)
    @Max(50)
    private Integer quantity;
    @NotNull
    private Integer categoryId;
}