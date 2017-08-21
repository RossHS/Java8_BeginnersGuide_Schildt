package Ch09_ExceptionHandling;

/**
 * Created by Ross on 21.08.2017.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        int num1[] = {4,14,5,8,9,10};
        int num2[] = {2,7,0,2};
        try {
            for (int i = 0; i < num1.length ; i++) {
                try {
                    System.out.println(num1[i] + "/" + num2[i] + " = " + div(num1[i], num2[i]));
                } catch (ArithmeticException ex){
                    System.out.println("деление на ноль");
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("нет элемента массива");
            //Объявляя исключение в исключении мы можем не проверять
            //цикл еще раз на наличие элементов масива
        }
    }
    //throws ArithmeticException, ArrayIndexOutOfBoundsException можно не объявлять,
    //так как они загружены автоматически
    static int div(int num1, int num2) throws ArithmeticException, ArrayIndexOutOfBoundsException{
        return num1/num2;
    }
}