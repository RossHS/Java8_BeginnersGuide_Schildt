package Ch11_MultithreadedProg;

/**
 * Created by Ross on 20.10.2017.
 */
public class ThreadQueue implements Runnable {
    Thread thrd;
    Queue qObj;

    ThreadQueue(String name, int num) {
        thrd = new Thread(this, name);
        thrd.start();
        qObj = new Queue(num);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            qObj.setQueue(i);
        }
        System.out.println("Очередь для потока " + thrd.getName());
        for (int i = 0; i < 10; i++) {
            int x = qObj.getQueue();
            if (x != 0) {
                System.out.print(x + " ");
            }
        }
    }
}

class Queue {
    int[] numq;
    private int setLoc, getLoc;

    Queue(int size) {
        numq = new int[size + 1];
        getLoc = setLoc = 0;
    }

    synchronized void setQueue(int i) {
        setLoc++;
        if (setLoc == numq.length - 1) {
            System.out.println("\nОчередь заполнена");
            return;
        }

        numq[setLoc] = i;
    }

    synchronized int getQueue() {
        if (getLoc == setLoc) {
            System.out.println("\nОчередь пуста");
            return 0;
        }
        getLoc++;
        return numq[getLoc];
    }

}

class QueueTest {
    public static void main(String[] args) {

        ThreadQueue tq1 = new ThreadQueue("Поток 1", 10);
        ThreadQueue tq2 = new ThreadQueue("Поток 2", 6);
        ThreadQueue tq3 = new ThreadQueue("Поток 3", 10);

        try {
            tq1.thrd.join();
            System.out.println(tq1.thrd.getName() + " Завершен");
            tq2.thrd.join();
            System.out.println(tq2.thrd.getName() + " Завершен");
            tq3.thrd.join();
            System.out.println(tq3.thrd.getName() + " Завершен");

        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        System.out.println("Основной поток завершен");
    }
}
