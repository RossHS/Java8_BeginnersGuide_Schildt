package Ch11_MultithreadedProg;

/**
 * Created by Ross on 19.10.2017.
 */
public class Priority implements Runnable {
    int count;
    Thread thread;

    static boolean stop = false;
    static String currentName;

    /*
    Создание нового потока, поток не запускаем на выполнение
     */
    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " - запуск");
        do {
            count++;
            if (currentName.compareTo(thread.getName()) != 0) {
                currentName = thread.getName();
                System.out.println("В " + currentName);
            }
        } while (stop == false && count < 10_000_000);
        stop = true;

        System.out.println("\n" + thread.getName() + " - завершен");
    }
}

class PriorityDemo {
    public static void main(String[] args) {
        Priority mt1 = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");

        //задаем приоритет
        mt1.thread.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.thread.setPriority(Thread.NORM_PRIORITY - 2);

        //запускаем потоки на выполнение
        mt1.thread.start();
        mt2.thread.start();

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException exc) {
            System.out.println("Прерывание основного потока");
        }
        System.out.println("\nСчетчик потока High Priority:" + mt1.count);
        System.out.println("Счетчик потока Low Priority:" + mt2.count);
    }
}