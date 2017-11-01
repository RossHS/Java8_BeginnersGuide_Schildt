package B_JavaDoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс, демонстрирующий использование
 * документирующих комментариев
 *
 * @author Ross
 * @version 1.0
 * Created by Ross on 01.11.2017.
 */

public class Example {
    /**
     * Метод возвращает квадрат значения параметра num.
     * Это описание состоит из нескольких строк.
     * Число строк не ограничивается
     *
     * @param num Значение, которое требуется возвести в квадрат.
     * @return Квадрат числового значения параметра num.
     */
    public double square(double num) {
        return num * num;
    }

    /**
     * Этот метод получает значение, введенное пользователем.
     *
     * @throws IOException Исключение при ошибке ввода.
     * @retunr Введенное значение типа double.
     * @see IOException
     */
    public double getNumber() throws IOException {
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = inData.readLine();
        return (new Double(str)).doubleValue();
    }

    /**
     * В этом методе демонстрируется применение метода square().
     *
     * @param args не используется.
     * @throws IOException Исключение при ошибке ввода.
     * @see IOException
     */
    public static void main(String[] args) throws IOException {
        Example ob = new Example();
        double val;
        System.out.println("Введите значение для возведения в квадрат: ");
        val = ob.getNumber();
        val = ob.square(val);
        System.out.println("Квадрат введенного значения " + val);
    }
}
