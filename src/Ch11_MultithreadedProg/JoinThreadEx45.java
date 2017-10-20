package Ch11_MultithreadedProg;

/**
 * Created by Ross on 20.10.2017.
 */
public class JoinThreadEx45 implements Runnable {
    Thread thrd;
    int[] nums;
    int result;

    JoinThreadEx45(String name, int[] nums) {
        thrd = new Thread(this, name);
        this.nums = nums;
    }

    @Override
    public void run() {
//        try {
            for (int i = 0; i < nums.length; i++) {
                result += nums[i];
                System.out.println("Сумма массива для " + thrd.getName() + " = " + result);
             //   thrd.sleep();
            }
//        } catch (InterruptedException exc) {
//            exc.printStackTrace();
//        }
    }
}

class JoinTestDrive {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 4};
        int[] num2 = {10, 20, 30, 40};
        System.out.println("Запуск основного цикла");
        JoinThreadEx45 thread1 = new JoinThreadEx45("Number 1", num1);
        JoinThreadEx45 thread2 = new JoinThreadEx45("Number 2", num2);

        thread1.thrd.setPriority(Thread.NORM_PRIORITY + 3);
        thread2.thrd.setPriority(Thread.NORM_PRIORITY);

        thread1.thrd.start();
        thread2.thrd.start();
        try {

            thread1.thrd.join();
            System.out.println("Первый поток присоединен");
            thread2.thrd.join();
            System.out.println("Второй поток присоединен");

        } catch (InterruptedException exc) {
            System.out.println("Основной поток прервался");
        }
        System.out.println("Основной поток завершен");
    }
}
