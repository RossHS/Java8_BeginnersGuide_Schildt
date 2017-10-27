package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
public class Ex7 {
    public static void main(String[] args) {
        NumericFunc factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("Факториал 3 = " + factorial.func(3));
        System.out.println("Факториал 5 = " + factorial.func(5));
    }
}
