package Entity;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Receipt implements Serializable {
    private Long id;
    @Setter(AccessLevel.NONE)
    private List<Article> articlesOnReceipt = new ArrayList<>();
}
