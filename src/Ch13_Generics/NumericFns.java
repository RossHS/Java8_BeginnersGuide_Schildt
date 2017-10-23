package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */

//т.е. дженериком сюда любой класс Number
//или его подкласс Integer, Double
public class NumericFns<T extends Number> {
    T num;

    NumericFns(T n) {
        num = n;
    }

    double reciprocal() {
        return 1 / num.doubleValue();
    }

    double fraction() {
        return num.doubleValue() - num.intValue();
    }

    //Используем шаблон аргумента ? (Метасимвол), так если оставить T, то в качестве
    //аргумента можно будет передать только тот же тип, что и T
    //т.е. если T Integer, то его не сравнить с Double
    boolean absEqual(NumericFns<?> ob) {
        if (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue()))
            return true;
        return false;
    }
}

class BoundsDemo {
    public static void main(String[] args) {
        NumericFns<Integer> iOb = new NumericFns<Integer>(5);

        System.out.println("Обратная величина iOb - " + iOb.reciprocal());
        System.out.println("Дробная часть iOb - " + iOb.fraction());

        System.out.println();
        NumericFns<Double> dOb = new NumericFns<Double>(5.0);

        System.out.println("Обратная величина dOb - " + dOb.reciprocal());
        System.out.println("Дробная часть dOb - " + dOb.fraction());

        System.out.println(iOb.absEqual(dOb));


        //Неподходит так как дженерик ждет классы типа Number
        //NumericFns<String> strObj = new NumericFns<String>("123");
    }
}

class PairGen<T, V extends T> {
    T first;
    V second;

    PairGen(V a, V b) {
        first = a;
        second = b;
    }

    class PairTest {
        //Работает так как обобщение V имеет тот же тип что и T (или производный от него)
        PairGen<Integer, Integer> x = new PairGen<Integer, Integer>(1, 2);
        PairGen<Number, Integer> y = new PairGen<Number, Integer>(12, 3);

        //А тут ошибка так как V не имеет никакого отношения к типу класса T
        //PairGen<Number, String> z = new PairGen<Number, String>(19,"12");

    }
}
