package Ch11_MultithreadedProg;

/**
 * Created by Ross on 20.10.2017.
 */
public class Synchron {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        MyThreadSyn mt1 = new MyThreadSyn("Child #1", a);
        MyThreadSyn mt2 = new MyThreadSyn("Child #2", a);
    }
}

class SumArray {
    private int sum;

    synchronized int sumArray(int[] nums) {
        sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Текущее значение суммы для " +
                    Thread.currentThread().getName() + ": " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание основного потока");
            }
        }
        return sum;
    }
}

class MyThreadSyn implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    //Создадим поток
    MyThreadSyn(String name, int nums[]) {
        thrd = new Thread(this, name);
        a = nums;
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " - запуск");

        answer = sa.sumArray(a);
        System.out.println("Сумма для " + thrd.getName() + ": " + answer);
        System.out.println(thrd.getName() + " - завершение");
    }
}