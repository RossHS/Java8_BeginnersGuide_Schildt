package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
//обобщенный конструктор
public class Summation {
    private int sum;

    <T extends Number> Summation(T arg) {
        sum = 0;

        for (int i = 0; i <= arg.intValue(); i++) {
            sum += i;
        }
    }

    int getSum() {
        return sum;
    }
}

class GenConsDemo {
    public static void main(String[] args) {
        Summation ob = new Summation(4.0);

        System.out.println("Сумма целых чисел от 0 до 4.0 равна " + ob.getSum());
    }
}
