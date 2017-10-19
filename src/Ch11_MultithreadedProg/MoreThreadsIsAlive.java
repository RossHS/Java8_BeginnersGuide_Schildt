package Ch11_MultithreadedProg;

/**
 * Created by Ross on 19.10.2017.
 */
public class MoreThreadsIsAlive {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        //Создаем объект типа MyThread
        MyThreadNew mt1 = new MyThreadNew("Child #1");
        MyThreadNew mt2 = new MyThreadNew("Child #2");
        MyThreadNew mt3 = new MyThreadNew("Child #3");


        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        } while (mt1.isAlive() ||
                 mt2.isAlive() ||
                 mt3.isAlive());
        System.out.println("Завершение основного потока");
    }
}
