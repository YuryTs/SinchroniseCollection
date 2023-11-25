package ru.cvetkov.systemcontrol;

import java.util.ArrayList;
import java.util.List;

public class EventedList {
    private List<String> list = new ArrayList<>();

    private EventPublisher publisher;

    public void add(String object) {
        list.add(object);
        publishEvent(EventType.ADD, object);
    }

    public void remove(int i) {
        String removed = list.remove(i);
        publishEvent(EventType.DELETE, removed);
    }

    public void setPublisher(EventPublisher publisher) {
        this.publisher = publisher;
    }

    private void publishEvent(EventType type, String item) {
        if (publisher == null) {
            return;
        }

        publisher.publish(new Event(type, item));
    }
}
