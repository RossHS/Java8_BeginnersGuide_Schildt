package Ch03_Program_Control_Statements;

import java.util.Scanner;

/**
 * Created by Ross on 15.08.2017.
 */
public class CapitalLetter {
    public static void main(String[] args) {
        char text;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            text = scanner.next().charAt(0);
            if (text >= 'a' && text <= 'z') {
                text -= 32;
                System.out.println(text);
                count++;
            }
            else if (text >= 'A' && text <= 'Z'){
                text += 32;
                System.out.println(text);
                count++;
            }
        } while (text != '.');
        System.out.println("Всего изменений- " + count);
    }
}
