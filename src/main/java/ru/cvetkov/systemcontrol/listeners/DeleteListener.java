package ru.cvetkov.systemcontrol.listeners;

import ru.cvetkov.systemcontrol.Event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteListener implements EventListener{
    File deleteFile = new File("deleted.txt");
    @Override
    public void accept(Event event) {
        System.out.println("Deleted " + event.getObject());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(deleteFile, true))) {
            writer.append(' ');
            writer.append(event.getObject().toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
