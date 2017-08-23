package Ch10_UsingIO;

import java.io.*;

/**
 * Created by Ross on 23.08.2017.
 */
/*
Сравнение двух файлов.
При вызове этой программы следует указать имена
сравниваемых файлов. Например, чтобы сравнить файл
FIRST.TXT с файлом SECOND.TXT, в командной строке
нужно ввести следующую команду:

java CompFile FIRST.TXT SECOND.TXT
 */
public class CompFiles {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        //Прежде всего надо убедиться, что программе
        // передаются имена обоих файлов.
        if (args.length != 2) {
            System.out.println("Использование: CompFiles файл1 файл2");
            return;
        }

        //сравнить файлы
        try (FileInputStream f1 = new FileInputStream(args[0]);
             FileInputStream f2 = new FileInputStream(args[1])) {
            //Проверим содержимое каждого файла
            do {
                i = f1.read();
                j = f2.read();
                if (i != j) break;
            } while (i != -1 && j != -1);
            if (i != j) {
                System.out.println("Содержимое файлов отличается");
            } else
                System.out.println("Содержимое файлов совпадает");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
