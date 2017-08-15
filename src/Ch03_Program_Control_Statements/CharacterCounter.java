package Ch03_Program_Control_Statements;

import java.util.Scanner;

/**
 * Created by Ross on 15.08.2017.
 */
public class CharacterCounter {
    public static void main(String[] args) {
        int character = 0;
        int spaces = 0;
        System.out.println("Введите стоку для посчета в ней символов и пробелов до точки");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                break;
            }
            if (text.charAt(i) == ' ') {
                spaces++;
            } else
                character++;

        }
        System.out.println("Символов:" + character);
        System.out.println("Пробелов:" + spaces);
    }
}
