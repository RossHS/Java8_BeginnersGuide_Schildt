package Ch11_MultithreadedProg;

/**
 * Created by Ross on 20.10.2017.
 */
public class NotifyWait {
}


//Использование методов wait() и notify() для имитации часов
class TickTock {
    String state;

    synchronized void tick(boolean running) {
        if (!running) { //остановить часы
            state = "ticked";
            notify();
            return;
        }

        System.out.print("Tick ");

        state = "ticked";

        notify();
        try {
            while (!state.equals("tocked"))
                wait();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    synchronized void tock(boolean running) {
        if (!running) { //остановить часы
            state = "tocked";
            notify();
            return;
        }

        System.out.println("Tock");

        state = "tocked";

        notify();
        try {
            while (!state.equals("ticked"))
                wait();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}

class MyThreadNotifyWait implements Runnable {
    Thread thrd;
    TickTock ttOb;

    MyThreadNotifyWait(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
        thrd.start();
    }

    @Override
    public void run() {
        if (thrd.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) {
                ttOb.tick(true);
            }
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }
}

class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThreadNotifyWait mt1 = new MyThreadNotifyWait("Tick", tt);
        MyThreadNotifyWait mt2 = new MyThreadNotifyWait("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}