package iss.sirius.Event;


import iss.sirius.Model.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateMessageEvent extends BaseEvent {
    private final Message message;

    public CreateMessageEvent(Message message) {
        super(EventType.MESSAGE_CREATED);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
