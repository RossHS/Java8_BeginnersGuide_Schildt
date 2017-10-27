package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
interface Ex8MyFunc<T> {
    T func(T arg);
}

public class Ex8 {
    public static void main(String[] args) {
        Ex8MyFunc<Integer> factorial = (n)->{
            int result =1;
            for (int i = 1; i <= n ; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("факториал 4 = " + factorial.func(4));
    }
}
