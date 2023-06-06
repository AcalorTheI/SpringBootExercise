package Entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Article implements Serializable {
    private Long id;
    private String name;
    private String barCode;
    private BigDecimal price;
}
