package ru.cvetkov.systemcontrol.listeners;

import ru.cvetkov.systemcontrol.Event;

public interface EventListener {
    void accept(Event event);
}
