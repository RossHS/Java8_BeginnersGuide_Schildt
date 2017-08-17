package Ch05_MoreDataTypes_Operators;

/**
 * Created by Ross on 17.08.2017.
 */
class Queue {
    char q[];
    int intq[]; //для хранения int
    int setLoc, getLoc;

    Queue(int size){
        q = new char[size + 1];
        intq = new int[size + 1];
        setLoc = getLoc = 0;
    }
    //Заносим символ в очередь
    void set(char ch){
        if (setLoc == q.length - 1){
            System.out.println("- очередь заполнена");
            return;
        }
        setLoc++;
        q[setLoc] = ch;
    }
    //реализуем через перегрузку
    void set(int inte){
        if (setLoc == q.length - 1){
            System.out.println("- очередь заполнена");
            return;
        }
        setLoc++;
        intq[setLoc] = inte;
    }
    int getInt() {
        if (getLoc == setLoc) {
            System.out.println(" - очередь пуста");
            return 0;
        }
        getLoc++;
        return intq[getLoc];
    }

    //Извлекаем символ из очереди
    char get() {
        if (getLoc == setLoc) {
            System.out.println(" - очередь пуста");
            return (char) 0;
        }
        getLoc++;
        return q[getLoc];
    }
}


//Демонстрация использования класса Queue
class QDemo{
    public static void main(String[] args) {
        Queue bigQ = new Queue(100);
        Queue smallQ = new Queue(4);
        Queue intQ = new Queue(10);
        int iq;
        char ch;

        System.out.println("Использование очереди intQ для сохранения чисел");
        //поместить числа в очередь intQ
        for (int i = 0; i < intQ.intq.length-1; i++) {
            intQ.set(1+i);
        }

        //Извлечь цифру из очереди и отобразить
        System.out.print("Содержимое очереди intQ:");
        for (int i = 0; i < intQ.intq.length-1; i++) {
            iq = intQ.getInt();
            if(iq !=  0){
                System.out.print(" " + iq);
            }
        }

        System.out.println();

        System.out.println("Использование очереди bigQ для сохранения Алфавита");
        //поместить букв символ в очередь bigQ
        for (int i = 0; i < 26 ; i++) {
            bigQ.set((char) ('A' + i));
        }

        //Извлечь букв символ из очереди и отобразить
        System.out.print("Содержимое очереди bigQ: ");
        for (int i = 0; i < 26 ; i++) {
            ch = bigQ.get();
            if(ch != (char) 0){
                System.out.print(ch);
            }
        }

        System.out.println("\n");

        System.out.println("Использование очереди smallQ для генерациии ошибок");
        //Использовать очередь smallQ для генерации ошибок
        for (int i = 0; i < 5; i++) {
            System.out.print("Попытка сохранения " + (char) ('Z' - i));

            smallQ.set((char) ('Z' - i));

            System.out.println();
        }
        System.out.println();

        //дополнительные ошибки при обращении к очереди smallQ
        System.out.print("Содержимое smallQ: ");
        for (int i = 0; i < 5; i++) {
            ch = smallQ.get();
            if (ch != (char) 0){
                System.out.print(ch);
            }
        }
    }
}