package Ch11_MultithreadedProg;

/**
 * Created by Ross on 19.10.2017.
 */
class MyThreadNew extends Thread {

    MyThreadNew(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        System.out.println(getName() + " -запуск");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("B " + getName() + ", счетчик " + i);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
            System.out.println(getName() + " - прерван");
        }
        System.out.println(getName() + "Завершен");
    }
}

class ExtendedThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        //Создаем объект типа MyThread
        MyThreadNew mt = new MyThreadNew("Child #1");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание основного потока");
            }
        }
        System.out.println("Завершение основного потока");
    }
}
