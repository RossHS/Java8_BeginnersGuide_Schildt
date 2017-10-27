package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
public class LambdaExceptionDemo {
    public static void main(String[] args) {
        double[] values = {1.0,2.0,3.0,4.0};

        //данное лямбда выражение может генерировать исключение
        //IOException следовательно это исключение должно быть указано
        //в операторе throws метода ioAction() функ интерфейса
        MyIOAction myIO = (rdr) -> {
            int ch = rdr.read();
            return true;
        };
    }
}
