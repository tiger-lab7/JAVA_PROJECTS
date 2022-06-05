package org.example;

import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicLong;


public class App 
{
    public static void main( String[] args )
    {
        /*Создаём объект phaser и передаем туда пока одну сторону - главный поток, остальные будут
        добавляться при вызове метода phaser.register() внутри каждого */

        Phaser phaser = new Phaser(1); // "1" to register self

        new Thread(new doingWork(phaser, "First thread")).start();
        new Thread(new doingWork(phaser, "Second thread")).start();
        new Thread(new doingWork(phaser, "Third thread")).start();
        new Thread(new doingWork(phaser, "Fourth thread")).start();

        int phase = phaser.getPhase();

        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // Ожидаем завершения всех потоков и снимаем с них регистрацию
        phaser.arriveAndDeregister();
    }
}



class doingWork implements Runnable {
    private Phaser phaser;
    private String name;
    doingWork(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;

        //В конструкторе регистрирум данный объект в объекте phaser
        phaser.register();
    }


    private AtomicLong al = new AtomicLong(0);
    public void run() {

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        counter(1);
        phaser.arriveAndAwaitAdvance(); // сообщаем объекту phaser, что первая фаза достигнута

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        counter(2);
        phaser.arriveAndAwaitAdvance(); // сообщаем объекту phaser, что вторая фаза достигнута

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        counter(3);
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
    }

    private void counter(int mod) {
        for(long i = 0; i < Integer.MAX_VALUE; i += 10) {
            al.set(i);
        }
        al.set(al.get() * mod);
        System.out.println(name + ": " + al);
    }
}

