package ru.cvetkov.systemcontrol;

public class Event {
    private final EventType type;
    private final String object;

    public Event(EventType type, String object) {
        this.type = type;
        this.object = object;
    }

    public EventType getType() {
        return type;
    }

    public String getObject() {
        return object;
    }
}
