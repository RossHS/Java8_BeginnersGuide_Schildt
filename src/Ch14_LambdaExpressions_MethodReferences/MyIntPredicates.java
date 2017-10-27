package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
interface IntPredicate {
    boolean test(int n);
}

public class MyIntPredicates {
    //Статический метод, возвращает true, если
    //заданное число простое
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if ((n % i) == 0)
                return false;
        }
        return true;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }
}

class MethodRefDemo {
    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }

    public static void main(String[] args) {
        boolean result;

        //Передаем ссылку на метод
        result = numTest(MyIntPredicates::isPrime, 17);
        if (result) System.out.println("17 простое число");

        result = numTest(MyIntPredicates::isPositive, 11);
        if (result) System.out.println("11 положительное число");

        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);

        //создаем ссылку на метод isFactor объекта myNum
        IntPredicate ip = myNum::isFactor;
        //используем ссылку для вызова метода isFactor
        //через метод test
        result = ip.test(3);
        if (result) System.out.println("3 является делителем " + myNum.getNum());

        ip = myNum::hasCommonFactor;
        result = ip.test(9);
        if (result)
            System.out.println("Общий делитель найден");
    }
}

class MyIntNum {
    private int v;

    MyIntNum(int x) {
        v = x;
    }

    int getNum() {
        return v;
    }

    //тру если n делитель v
    boolean isFactor(int n) {
        return v % n == 0;
    }

    boolean hasCommonFactor(int n) {
        for (int i = 2; i < v / i; i++) {
            if ((v % i) == 0 && ((n % i) == 0)) return true;
        }
        return false;
    }
}