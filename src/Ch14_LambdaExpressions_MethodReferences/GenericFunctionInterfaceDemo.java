package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 26.10.2017.
 */
public class GenericFunctionInterfaceDemo {
    public static void main(String[] args) {
        GenLamb<Integer> isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2))
            System.out.println("2 является делителем 10");
        System.out.println();

        GenLamb<Double> isFactorD = (n, d) -> (n % d) == 0;
        if (isFactorD.test(212.0, 4.0))
            System.out.println("4 является делителем 212");
        System.out.println();

        GenLamb<String> isIn = (a, b) -> a.indexOf(b) != -1;

        String strA = "Обобщенный функциональный интерфейс";
        if(isIn.test(strA,"интер"))
            System.out.println("интер найдено");
        else System.out.println("интер не найдено");
    }
}
