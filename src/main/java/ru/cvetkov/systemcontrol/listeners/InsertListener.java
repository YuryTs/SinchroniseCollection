package ru.cvetkov.systemcontrol.listeners;

import ru.cvetkov.systemcontrol.Event;

import java.io.*;
import java.nio.file.Files;

public class InsertListener implements EventListener {
    File insertFile = new File("inserted.txt");
    @Override
    public void accept(Event event) {
        System.out.println("Inserted " + event.getObject());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(insertFile, true))) {
            writer.append(' ');
            writer.append(event.getObject().toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
