package Ch03_Program_Control_Statements;

import java.io.IOException;

/**
 * Created by Ross on 15.08.2017.
 */
public class Help {
    public static void main(String[] args) throws IOException {
        System.out.println("Справка: ");
        System.out.println(" 1. if");
        System.out.println(" 2. switch");
        System.out.print("Выберите: ");
        char choice = (char) System.in.read();

        System.out.println("\n");

        switch (choice) {
            case '1':
                System.out.println("Оператор if:\n");
                System.out.println("if (условие) операторы;");
                System.out.println("else оператор;");
                break;
            case '2':
                System.out.println("Оператор switch:\n");
                System.out.println("switch(выражение) {");
                System.out.println(" case константа:");
                System.out.println(" последовательность операторов");
                System.out.println(" break;");
                System.out.println(" // ...");
                System.out.println("}");
                break;
            default:
                System.out.println("запрос не найден.");
        }
    }
}
