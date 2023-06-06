package Entity;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventMessage implements Serializable {
    Object payload;
    @Setter(AccessLevel.NONE)
    Long timestamp;
    EventMessageType messageType;
}
