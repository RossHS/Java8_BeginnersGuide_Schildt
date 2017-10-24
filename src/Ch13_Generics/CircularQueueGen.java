package Ch13_Generics;

/**
 * Created by Ross on 24.10.2017.
 */
public class CircularQueueGen<T> implements IGenQ<T> {
    private T q[];
    private int putLoc, getLoc;

    public CircularQueueGen(T[] aRef) {
        q = aRef; //выделить память для очереди
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(T obj) throws QueueFullException {
        if (putLoc + 1 == getLoc | ((putLoc == q.length - 1) & (getLoc == 0))) {
            throw new QueueFullException(q.length);
        }
        putLoc++;
        if (putLoc == q.length)
            putLoc = 0; //перейти в начало массива
        q[putLoc] = obj;
    }


    @Override
    public T get() throws QueueEmptyException {
        if (getLoc == putLoc) {
            throw new QueueEmptyException();
        }
        getLoc++;
        if (getLoc == q.length) {
            getLoc = 0; //вернуться в начало очереди
        }
        return q[getLoc];
    }
}

class CircularQueueGenDemo {
    public static void main(String[] args) {

        CircularQueueGen<Integer> iq = new CircularQueueGen<>(new Integer[10]);

        int iVal;

        System.out.println("Демонстрация очереди чисел типа Integer");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Добавление " + i + " в очередь iq");
                iq.put(i);
            }
        } catch (QueueFullException exc) {
            exc.printStackTrace();
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Получение следующего числа типа " + iq.getClass().getSimpleName() +
                        " из очереди iq:");
                iVal = iq.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exc) {
            exc.printStackTrace();
        }
        System.out.println();

    }
}