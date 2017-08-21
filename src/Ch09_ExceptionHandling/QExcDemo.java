package Ch09_ExceptionHandling;

/**
 * Created by Ross on 21.08.2017.
 */
class QExcDemo {
    public static void main(String[] args) {
        FixedQueue q = new FixedQueue(10);
        char ch;
        int i;

        try{
            //переполнение очереди
            for (i = 0; i < 11 ; i++) {
                System.out.print("Попытка сохранения: " + (char) ('A' + i));
                q.put((char)('A' + i));
                System.out.println(" - OK");
            }
            System.out.println();
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            //извлечь символ из пустой очереди
            for (i = 0; i < 11; i++){
                System.out.print("Получение очередного символа: ");
                ch = q.get();
                System.out.println(ch);
            }
        } catch (QueueEmptyException exc){
            System.out.println(exc);
        }
    }
}

//Добавление обработчика исключений в очередь

//Исключение, указывающее на переполнение очереди
class QueueFullException extends Exception{
    int size;

    QueueFullException(int s) {
        size = s;
    }

    @Override
    public String toString() {
        return "\nОчередь заполнена. Максимальный размер очереди: " + size;
    }
}

// Исключение, указывающее на исчерпание очереди
class QueueEmptyException extends Exception{
    @Override
    public String toString() {
        return "\nОчередь пуста.";
    }
}

class FixedQueue{
    private char q[];
    private int putLoc, getLoc;

    FixedQueue(int size) {
        q = new char[size + 1];
        putLoc = 0;
        getLoc = 0;
    }

    public void put(char ch) throws QueueFullException{
            if (putLoc == q.length -1)
                throw new QueueFullException(q.length - 1);
            putLoc++;
            q[putLoc] = ch;
        }

    public char get() throws QueueEmptyException {
        if (getLoc == putLoc){
        throw new QueueEmptyException();
        }
        getLoc++;
        return q[getLoc];
    }
}