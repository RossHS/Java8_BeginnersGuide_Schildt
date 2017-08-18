package Ch06_CloserLookAt_Methods_Classes;

/**
 * Created by Ross on 18.08.2017.
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack bigQ = new Stack(10);
        char ch;

        System.out.println("Использование стека bigQ для сохранения Алфавита");
        //поместить букв символ в стек bigQ
        for (int i = 0; i < 10 ; i++) {
            bigQ.set((char) ('A' + i));
        }

        System.out.print("Содержимое стека bigQ: ");
        for (int i = 0; i < 10 ; i++) {
            ch = bigQ.get();
            System.out.print(ch);
        }
    }
}
