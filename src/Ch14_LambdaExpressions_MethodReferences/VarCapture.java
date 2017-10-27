package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
public class VarCapture {
    static int val = 10;
    public static void main(String[] args) {
        int num = 10;

        NumericFunc myLambda = (n) -> {
            //изменять значение локальных переменных в лямбда выражениях недопускается
            //num++ не сработает!!!
            int v = num + n;
            val++;
            return v;
        };

        System.out.println(myLambda.func(8));
        System.out.println(val);
    }
}
