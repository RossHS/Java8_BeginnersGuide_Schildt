package Ch11_MultithreadedProg;

/**
 * Created by Ross on 19.10.2017.
 */
class MyThread implements Runnable {
    Thread thread;

    MyThread(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " -запуск");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("B " + thread.getName() + ", счетчик " + i);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
            System.out.println(thread.getName() + " - прерван");
        }
        System.out.println(thread.getName() + "Завершен");
    }
}

class UseThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        //Создаем объект типа MyThread
        MyThread mt1 = new MyThread("Child #1");
        MyThread mt2 = new MyThread("Child #2");
        MyThread mt3 = new MyThread("Child #3");

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


