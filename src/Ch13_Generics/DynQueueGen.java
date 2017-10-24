package Ch13_Generics;

/**
 * Created by Ross on 24.10.2017.
 */
public class DynQueueGen<T> implements IGenQ<T> {
    private T q[];
    private int putLoc, getLoc;

    //Создать пустую очередь заданного размера
    public DynQueueGen(T[] aRef) {
        this.q = aRef;
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(T obj) throws QueueFullException {
        if (putLoc == q.length - 1) {
            T t[] = (T[]) new DynQueueGen<?>[q.length * 2];

            for (int i = 0; i < q.length; i++) {
                t[i] = q[i];
            }
            q = t;
        }
        q[putLoc++] = obj;
    }

    @Override
    public T get() throws QueueEmptyException {
        if (getLoc == putLoc) throw new QueueEmptyException();
        return q[getLoc++];
    }
}
class DynQueueGenDemo{
    public static void main(String[] args) {

        DynQueueGen<Integer> dqg1 = new DynQueueGen<>(new Integer[10]);
        int iVal;

        System.out.println("Демонстрация очереди чисел типа Integer");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Добавление " + i + " в очередь dqg1");
                dqg1.put(i);
            }
        } catch (QueueFullException exc) {
            exc.printStackTrace();
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Получение следующего числа типа " + dqg1.getClass().getSimpleName() +
                        " из очереди dqg1:");
                iVal = dqg1.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exc) {
            exc.printStackTrace();
        }
        System.out.println();
    }
}