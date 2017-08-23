package Ch10_UsingIO;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Ross on 23.08.2017.
 */
public class RandomAccessDemo {
    public static void main(String[] args) {
        double data[] = {19.4, 10.1, 123.41, 412.1, 33.0, 12.1};
        double d;

        //Открыть и использовать файл с произвольным доступом
        try (RandomAccessFile raf = new RandomAccessFile("src/Ch10_UsingIO/testRA.txt", "rw")) {
            //Записать значения в файл
            for (int i = 0; i < data.length; i++) {
                raf.writeDouble(data[i]);
            }

            //Прочитать отдельные значения из файла
            raf.seek(0); //найти значение типа double
            d = raf.readDouble();
            System.out.println("Первое значение: " + d);

            raf.seek(8);
            d = raf.readDouble();
            System.out.println("Второе значение: " + d);

            System.out.println("Чтение значений с нечетным порядковым номер: ");
            for (int i = 0; i < data.length; i += 2) {
                raf.seek(8 * i);
                d = raf.readDouble();
                System.out.println(d + " ");

            }

        } catch (IOException exc) {
            System.out.println("Ошибка ввода-вывода: " + exc);
        }
    }
}
