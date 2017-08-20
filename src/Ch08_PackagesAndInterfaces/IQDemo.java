package Ch08_PackagesAndInterfaces;

/**
 * Created by Ross on 20.08.2017.
 */
//Для очереди фиксированного размера
class FixedQueue implements ICharQ {
    private char q[]; //Массив для хранения элементов очереди
    private int putLok, getLoc; //индексы

    public FixedQueue(int size){
        q = new char[size + 1]; //выделить память для очереди
        putLok = 0;
        getLoc = 0;
    }

    //Поместить символ в очередь
    @Override
    public void put(char ch) {
        if (putLok == q.length - 1){
            System.out.println(" - очередь заполнена");
            return;
        }

        putLok++;
        q[putLok] = ch;
    }

    //Извлечь символ из очереди
    @Override
    public char get() {
        if (getLoc == putLok){
            System.out.println(" - очередь пуста");
            return (char) 0;
        }

        getLoc++;
        return q[getLoc];
    }

    @Override
    public void reset() {
        putLok = 0;
        getLoc = 0;
    }
}

//Кольцевая очередь
class CircularQueue implements ICharQ{
    private char q[];
    private int putLoc, getLoc;

    public CircularQueue(int size){
        q = new char[size + 1]; //выделить память для очереди
        putLoc = 0;
        getLoc = 0;
    }

    //Поместить символ в очередь
    @Override
    public void put(char ch) {
        /* Очередь считается полной, если индекс putLoc на единицу
            меньше индекса getLoc или если индекс putLoc указывает
            на конец массива, а индекс getLoc - на его начало */
        if (putLoc + 1 == getLoc | ((putLoc == q.length - 1) & (getLoc == 0))){
            System.out.println(" - очередь заполнена");
            return;
        }

        putLoc++;
        if(putLoc == q.length)
            putLoc = 0; //перейти в начало массива
        q[putLoc] = ch;
    }

    @Override
    public char get() {
        if (getLoc == putLoc) {
            System.out.println(" - очередь пуста");
            return (char) 0;
        }

        getLoc++;
        if (getLoc == q.length){
            getLoc = 0; //вернуться в начало очереди
        }
        return q[getLoc];
    }

    @Override
    public void reset() {
        putLoc = 0;
        getLoc = 0;
    }
}

//Динамическая очередь
class DynQueue implements ICharQ{
    private char q[];
    private int putLoc, getLoc;

    //Создать пустую очередь заданного размера
    public DynQueue(int size){
        q = new char[size + 1];
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(char ch) {
        if (putLoc == q.length - 1){
            //Увеличить размер очереди
            char t[] = new char[q.length*2];

            //Скопировать элементы в новую очередь
            for (int i = 0; i < q.length ; i++) {
                t[i] = q[i];
            }
            q = t;
        }
        putLoc++;
        q[putLoc] = ch;
    }

    @Override
    public char get() {
        if (getLoc == putLoc){
            System.out.println(" - очередь пуста");
            return (char) 0;
        }

        getLoc++;
        return q[getLoc];
    }

    @Override
    public void reset() {
        putLoc = 0;
        getLoc = 0;
    }
}

//Динамическая кольцевая очередь
class DynCircularQueue implements ICharQ{
    private char q[];
    private int putLoc, getLoc;

    DynCircularQueue(int size){
        q = new char[size + 1];
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(char ch) {
        if (putLoc == q.length - 1){
            //Увеличить размер очереди
            char t[] = new char[q.length*2];

            //Скопировать элементы в новую очередь
            for (int i = 0; i < q.length ; i++) {
                t[i] = q[i];
            }
            q = t;
        }
        putLoc++;
        q[putLoc] = ch;
    }

    @Override
    public char get() {
        if (getLoc == putLoc){
            System.out.println(" - очередь пуста");
            return (char) 0;
        }

        getLoc++;
        if (getLoc == q.length){
            getLoc = 0; //Вернемся в начало очереди
        }
        return q[getLoc];
    }

    @Override
    public void reset() {
        getLoc = 0;
        putLoc = 0;
    }
}

//Демонстрация работы
class IQDemo{
    public static void main(String[] args) {
        FixedQueue q1 = new FixedQueue(10);
        CircularQueue q2 = new CircularQueue(10);
        DynQueue q3 = new DynQueue(5);
        DynCircularQueue q4 = new DynCircularQueue(5);

        ICharQ iQ;

        char ch;
        int i;

        iQ = q1;
        //Очередь фиксированного размера
        for (i = 0; i < 10; i++) {
            iQ.put((char) ('A' + i));
        }
        //Отобразить содержимое очереди
        System.out.print("Содержимое очереди фиксированного размера: ");
        for (i = 0; i < 10; i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        iQ = q2;
        //Кольцевая очередь
        for (i = 0; i < 10; i++){
            iQ.put((char) ('A' + i));
        }

        //Отобразить ее содержимое
        System.out.print("Содержимое кольцевой очереди: ");
        for (i = 0; i < 10; i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }

        System.out.println();
        //Поместить больше символов в кольцевую очередь
        for (i = 10; i < 20; i++){
            iQ.put((char) ('A' + i));
        }

        //Отобразить содержимое кольцевой очереди
        System.out.print("Содержимое кольцевой очереди: ");
        for (i = 0; i < 10; i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }

        System.out.println("\nСохранение и использование данных кольцевой очереди");

        //Поместить символы в кольцевую очередь и извлечь их оттуда
        for ( i = 0; i < 20 ; i++) {
            iQ.put((char) ('A' + i));
            ch = iQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        iQ = q3;
        //Поместить ряд символов в динамическую очередь
        for (i = 0; i < 10; i++){
            iQ.put((char) ('Z' - i));
        }

        //Отобразить ее содержимое
        System.out.print("Содержимое динамической очереди: ");
        for (i = 0; i < 10; i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        iQ = q4;
        for (i = 0; i < 10; i++){
            iQ.put((char) ('A' + i));
        }

        System.out.print("Содержание динамически кольцевой очереди: ");
        for (i = 0; i < 10; i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }

        System.out.println();
        for (i = 10; i < 20; i++){
            iQ.put((char) ('A' + i));
        }
        System.out.print("Содержимое динамически кольцевой очереди: ");
        for (i = 0; i < 10; i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }
        System.out.println("\nСохранение и использование данных кольцевой очереди");

        //Поместить символы в кольцевую очередь и извлечь их оттуда
        for ( i = 0; i < 20 ; i++) {
            iQ.put((char) ('A' + i));
            ch = iQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}