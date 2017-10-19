package Ch11_MultithreadedProg;

/**
 * Created by Ross on 19.10.2017.
 */
public class JoinThread {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        //Создаем объект типа MyThread
        MyThreadNew mt1 = new MyThreadNew("Child #1");
        MyThreadNew mt2 = new MyThreadNew("Child #2");
        MyThreadNew mt3 = new MyThreadNew("Child #3");

        try {
            mt1.join();
            System.out.println("Child #1 - присоединен");
            mt2.join();
            System.out.println("Child #2 - присоединен");
            mt3.join();
            System.out.println("Child #3 - присоединен");
        } catch (InterruptedException exc) {
            System.out.println("Прерывание основного потока");
        }
        System.out.println("Завершение основного потока");
    }
}
