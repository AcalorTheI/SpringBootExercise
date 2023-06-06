package Entity;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Article {
    private Long id;
    private String name;
    private String barCode;
    private BigDecimal price;
}
