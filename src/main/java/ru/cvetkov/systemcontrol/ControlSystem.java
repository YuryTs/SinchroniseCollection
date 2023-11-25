package ru.cvetkov.systemcontrol;

import ru.cvetkov.systemcontrol.listeners.DeleteListener;
import ru.cvetkov.systemcontrol.listeners.InsertListener;

import java.util.Random;

public class ControlSystem {
    public static void main(String[] args) throws InterruptedException {
        EventPublisher publisher = new EventPublisher();
        publisher.start();

        EventedList list = new EventedList();
        list.setPublisher(publisher);

        publisher.subscribe(EventType.ADD, new InsertListener());
        publisher.subscribe(EventType.DELETE, new DeleteListener());

        int leftLimit = 97;
        int rightLimit = 122;
        int strLenhgt = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(strLenhgt);
        for (int i = 0; i < strLenhgt; i++) {
            int randomLimit = leftLimit + (int) (random.nextFloat()*(rightLimit-leftLimit +1));
            buffer.append((char) randomLimit);
            list.add(buffer.toString());
        }

        for (int i = 0; i < strLenhgt; i++) {
            list.remove(i);
        }

        System.out.println("Done");
        Thread.sleep(10000);


    }
}
