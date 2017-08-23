package Ch10_UsingIO;

import java.io.*;

/**
 * Created by Ross on 23.08.2017.
 */
//Запись и чтение двоичных данных
public class RWData {
    public static void main(String[] args) {
        int i = 10;
        double d = 1023.451;
        boolean b = true;

        /*Записать ряд значений
          Новый тип оператора try- try с ресурсами.
          По завершение блока try объявленный ресурс
          автоматически закрывается, что избавляет от
          необходимости вызывать метод close()*/
        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("src/Ch10_UsingIO/testRWD.txt"))) {
            System.out.println("Записано: " + i);
            dataOut.writeInt(i);

            System.out.println("Записано: " + d);
            dataOut.writeDouble(d);

            System.out.println("Записано: " + b);
            dataOut.writeBoolean(b);

            System.out.println("Записано: " + 12.2 * 7.4);
            dataOut.writeDouble(12.2 * 7.4);
        } catch (IOException exc) {
            System.out.println("Ошибка при записи" + exc);
            return;
        }

        System.out.println();
        //А теперь прочитать записанные значения
        //перед этим обнулив переменные
        i = 0;
        d = 0;
        b = false;

        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("src/Ch10_UsingIO/testRWD.txt"))) {
            i = dataIn.readInt();
            System.out.println("Прочитано " + i);

            d = dataIn.readDouble();
            System.out.println("Прочитано " + d);

            b = dataIn.readBoolean();
            System.out.println("Прочитано " + b);

            d = dataIn.readDouble();
            System.out.println("Прочитано " + d);
        } catch (IOException exc) {
            System.out.println("Ошибка чтения " + exc);
        }
    }
}
