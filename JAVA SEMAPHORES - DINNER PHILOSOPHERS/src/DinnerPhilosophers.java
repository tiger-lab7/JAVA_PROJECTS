import java.util.concurrent.Semaphore;

public class DinnerPhilosophers {

    public static void main(String[] args) {

        //Создаём объект Семафора и передаем ему в конструктор кол-во разрешений
        Semaphore semaphore = new Semaphore(2);


        new Philosopher("Сократ", semaphore).start();
        new Philosopher("Платон", semaphore).start();
        new Philosopher("Аристотель", semaphore).start();
        new Philosopher("Фалес", semaphore).start();
        new Philosopher("Пифагор", semaphore).start();
        //Вызываем метод .start у каждого объекта, определённый в классе Thread, который наш класс наследует
    }
}

class Philosopher extends Thread {

    private Semaphore semaphore; // Переменная-ссылка на объект семафора
    private String namePhilosopher;

    Philosopher(String namePhilosopher, Semaphore semaphore) {
        this.namePhilosopher = namePhilosopher;
        this.semaphore = semaphore; //Передаём ссылку на объект Семафора через констуктор в переменную класса

    }

    @Override
    public void run() {
        class eatingPhilosopher {

            void eating() {
                try {
                    semaphore.acquire(); //Тут выполнение метода каждого объекта "застревает" до разрешения семафора
                    System.out.println("Философ " + namePhilosopher + " садится за стол");
                    sleep(3000);
                    System.out.println(namePhilosopher + " поел! Он выходит из-за стола!");
                    semaphore.release();
                    sleep(3000);

                } catch (InterruptedException ex) {System.out.println("Что-то пошло не так...");}
            }
        }
        new eatingPhilosopher().eating();
        // Правило: создавать объект локального класса метода можно только внутри этого метода
    }
}
