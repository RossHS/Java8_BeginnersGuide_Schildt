package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 26.10.2017.
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        //данное лямбда выражение проверяет, кратно ли одно число другому
        NumericTest isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2))
            System.out.println("2 является делителем 10");
        if (!isFactor.test(10, 3))
            System.out.println("3 не является делителем 10");

        //данное лямбда-выражение возвращает true, если первый аргумент меньше второго
        NumericTest lessThan = (n, m) -> (n < m);

        if (lessThan.test(2, 10))
            System.out.println("2 меньше 10");
        if (!lessThan.test(10, 2))
            System.out.println("10 не меньше 2");

        //true если оба аргумента равны по абсолютной величине
        NumericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);

        if (absEqual.test(4, -4))
            System.out.println("Абсолютные величины 4 и -4 равны");
        if (!absEqual.test(4, -5))
            System.out.println("Абсолютные величины 4 и -5 не равны");

        //Опред является ли одна строка частью другой
        StringTest isIn = (a, b) -> a.indexOf(b) != -1;

        String str = "Это тест";
        System.out.println("Тестируемая строка" +  str);

        if(isIn.test(str,"тест"))
            System.out.println("'тест' найдено");
    }
}
