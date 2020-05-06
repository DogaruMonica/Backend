package iss.sirius.Event;

import lombok.Data;

@Data
public class BaseEvent {
    private EventType eventType;

    public BaseEvent() {
    }
    public BaseEvent(EventType eventType) {
        this.eventType = eventType;
    }
}
