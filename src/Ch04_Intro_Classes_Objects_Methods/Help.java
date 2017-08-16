package Ch04_Intro_Classes_Objects_Methods;

/**
 * Created by Ross on 16.08.2017.
 */

import java.io.IOException;

public class Help {
    public Help() {
    }

    void helpon(int what) {
        switch(what) {
            case 49:
                System.out.println("Оператор if:\n");
                System.out.println("if (условие) операторы;");
                System.out.println("else оператор;");
                break;
            case 50:
                System.out.println("Оператор switch:\n");
                System.out.println("switch(выражение) {");
                System.out.println(" case константа:");
                System.out.println(" последовательность операторов");
                System.out.println(" break;");
                System.out.println(" // ...");
                System.out.println("}");
                break;
            case 51:
                System.out.println("Оператор for:\n");
                System.out.print("for(инициализация; условие; итерация)");
                System.out.println(" оператор;");
                break;
            case 52:
                System.out.println("Оператор while:\n");
                System.out.println("while(условие) оператор;");
                break;
            case 53:
                System.out.println("Оператор do-while:\n");
                System.out.println("do{");
                System.out.println(" оператор;");
                System.out.println("} while (условие);");
                break;
            case 54:
                System.out.println("Оператор break:\n");
                System.out.println("break; или break метка;");
                break;
            case 55:
                System.out.println("Оператор continue:\n");
                System.out.println("continue; или continue метка;");
        }

        System.out.println();
    }

    void showmenu() {
        System.out.println("Справка: ");
        System.out.println(" 1. if");
        System.out.println(" 2. switch");
        System.out.println(" 3. for");
        System.out.println(" 4. while");
        System.out.println(" 5. do-while");
        System.out.println(" 6. break");
        System.out.println(" 7. continue\n");
        System.out.print("Выберите (q - выход): ");
    }

    boolean isvalid(int ch) {
        return !(ch < 49 | ch > 55 & ch != 113);
    }
}

class HelpClassDemo {
    HelpClassDemo() {

    }
    public static void main(String[] args) throws IOException {
        Help hlpobj = new Help();

        while(true) {
            hlpobj.showmenu();
            char choice = (char)System.in.read();

            char ignore;
            do {
                ignore = (char)System.in.read();
            } while(ignore != '\n');

            if (hlpobj.isvalid(choice)) {
                if (choice == 'q') {
                    return;
                }

                System.out.println("\n");
                hlpobj.helpon(choice);
            }
        }
    }
}
