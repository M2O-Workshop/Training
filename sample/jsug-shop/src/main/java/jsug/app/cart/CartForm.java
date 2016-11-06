package jsug.app.cart;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class CartForm implements Serializable {
    @NotEmpty
    @NotNull
    private Set<Integer> lineNo;
}