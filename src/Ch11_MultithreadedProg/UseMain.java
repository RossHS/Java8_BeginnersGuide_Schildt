package Ch11_MultithreadedProg;

/**
 * Created by Ross on 20.10.2017.
 */
public class UseMain {
    public static void main(String[] args) {
        Thread thrd;

        //Получаем ссылку на выполняющийся поток
        thrd = Thread.currentThread();

        //Отобразить имя основного потока
        System.out.println("Имя основного потока: " + thrd.getName());

        //Отобразить приоритет основого потока
        System.out.println("Приоритет: " + thrd.getPriority());

        System.out.println();

        //Установить имя и приоритет основного потока
        System.out.println("Установка имени и приоритет \n");
        thrd.setName("Thread #1");
        thrd.setPriority(Thread.NORM_PRIORITY+3);

        //Отобразить новое имя основного потока
        System.out.println("Имя нового основного потока: " + thrd.getName());

        //Отобразить новый приоритет основого потока
        System.out.println("Новый приоритет: " + thrd.getPriority());
    }
}
