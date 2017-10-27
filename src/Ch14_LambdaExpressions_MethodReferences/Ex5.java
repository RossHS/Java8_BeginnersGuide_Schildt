package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
interface Ex5Inte<T> {
    boolean isRanged(T n);
}

public class Ex5 {
    public static void main(String[] args) {
        Ex5Inte<Integer> res = (n) -> n >= 10 && n <= 20;
        System.out.println(res.isRanged(15));
    }
}
