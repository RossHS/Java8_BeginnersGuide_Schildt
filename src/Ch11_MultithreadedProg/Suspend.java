package Ch11_MultithreadedProg;

/**
 * Created by Ross on 20.10.2017.
 */
public class Suspend {
    public static void main(String[] args) {
        MyThreadSuspend ob1 = new MyThreadSuspend("My Thread");

        try{
            Thread.sleep(1000);

            ob1.mySuspend();
            System.out.println("Приостановка потока");
            Thread.sleep(1000);

            ob1.myResume();
            System.out.println("Возобновление поток");
            Thread.sleep(1000);

            ob1.mySuspend();
            System.out.println("Приостановка потока");
            Thread.sleep(1000);

            ob1.myResume();
            System.out.println("Возобновление поток");
            Thread.sleep(1000);

            ob1.mySuspend();
            System.out.println("Остановка потока");
            ob1.myStop();
        } catch (InterruptedException exc){
            System.out.println("Прерывание основного потока");
        }

        try{
            ob1.thrd.join();
        }catch (InterruptedException exc){
            System.out.println("Прерывание основного потока");
        }

        System.out.println("Выход из основного потока");
    }
}

class MyThreadSuspend implements Runnable {
    Thread thrd;

    volatile boolean suspended;
    volatile boolean stopped;

    MyThreadSuspend(String name) {
        thrd = new Thread(this, name);
        suspended = false;
        stopped = false;
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " - запуск");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if ((i % 10) == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thrd.getName() + " - прерван");
        }
        System.out.println(thrd.getName() + " - выход");
    }

    //остановить поток
    synchronized void myStop(){
        stopped = true;
        //полная остановка приостановленного объекта
        suspended = false;
        notify();
    }

    //Приостановить поток
    synchronized void mySuspend(){
        suspended = true;
    }

    //Возобновить поток
    synchronized void myResume(){
        suspended = false;
        notify();
    }
}
