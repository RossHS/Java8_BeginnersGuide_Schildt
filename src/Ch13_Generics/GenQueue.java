package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
public class GenQueue<T> implements IGenQ<T> {
    private T q[]; //для хранения массива

    private int putLoc, getLoc;

    public GenQueue(T[] aRef) {
        this.q = aRef;
        putLoc = getLoc = 0;
    }

    @Override
    public void put(T obj) throws QueueFullException {
        if (putLoc == q.length - 1) throw new QueueFullException(q.length);

        q[putLoc++] = obj;
    }

    //Извлечение элемента из очереди
    @Override
    public T get() throws QueueEmptyException {
        if (getLoc == putLoc) throw new QueueEmptyException();
        return q[getLoc++];
    }
}

class QueueFullException extends Exception {
    int size;

    QueueFullException(int s) {
        size = s;
    }

    @Override
    public String toString() {
        return "\nОчередь заполнена. Максимальный размер очереди " + size;
    }
}

class QueueEmptyException extends Exception {
    @Override
    public String toString() {
        return "\nОчередь пуста";
    }
}

class GenQDemo {
    public static void main(String[] args) {
        GenQueue<Integer> q = new GenQueue<Integer>(new Integer[10]);
        int iVal;

        System.out.println("Демонстрация очереди чисел типа Integer");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Добавление " + i + " в очередь q");
                q.put(i);
            }
        } catch (QueueFullException exc) {
            exc.printStackTrace();
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Получение следующего числа типа " + q.getClass().getSimpleName() +
                        " из очереди q:");
                iVal = q.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exc) {
            exc.printStackTrace();
        }
        System.out.println();

        GenQueue<Double> q2 = new GenQueue<Double>(new Double[10]);

        Double dVal;

        System.out.println("Демонстрация очереди числе типа Double");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Добавление " + (double) i / 2 + " в очередь q2");
                q2.put((double) i / 2);
            }
        } catch (QueueFullException exc) {
            exc.printStackTrace();
        }
        System.out.println();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Получение следующего числа типа Double из очереди q2: ");
                dVal = q2.get();
                System.out.println(dVal);
            }
        } catch (QueueEmptyException exc) {
            exc.printStackTrace();
        }
    }
}
