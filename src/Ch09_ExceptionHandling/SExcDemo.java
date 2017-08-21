package Ch09_ExceptionHandling;

/**
 * Created by Ross on 21.08.2017.
 */
public class SExcDemo {
    public static void main(String[] args) {
        StackExc bigS = new StackExc(10);
        char ch;

        System.out.println("Использование стека bigS для сохранения Алфавита");
        //поместить букв символ в стек bigQ
        try {
            for (int i = 0; i < 11 ; i++) {
                System.out.print("Попытка сохранения: " + (char) ('A' + i));
                bigS.set((char) ('A' + i));
                System.out.println(" - OK!");
            }
        }catch (StackFullException exc){
            System.out.println(exc);
        }

        System.out.println("Содержимое стека bigS: ");
        try {
            for (int i = 0; i < 11 ; i++) {
                System.out.print("Получение очередного символа: ");
                ch = bigS.get();
                System.out.println(ch);
            }
        } catch (StackEmptyException exc){
            System.out.println(exc);
        }

    }
}

class StackFullException extends Exception{
    int size;

    StackFullException(int s) {
        size = s;
    }

    @Override
    public String toString() {
        return "\nОчередь заполнена. Максимальный размер очереди: " + size;
    }
}

class StackEmptyException extends Exception{
    @Override
    public String toString() {
        return "\nОчередь пуста.";
    }
}

class StackExc{
    private char stack[];
    private int tos;

    StackExc(int size){
        stack = new char[size];
        tos= 0;
    }

    void set(char ch) throws StackFullException{
        if (tos == stack.length){
            throw new StackFullException(stack.length);
        }
        stack[tos] = ch;
        tos++;
    }

    char get() throws StackEmptyException{
        if (tos==0){
            throw new StackEmptyException();
        }
        tos--;
        return stack[tos];
    }
}