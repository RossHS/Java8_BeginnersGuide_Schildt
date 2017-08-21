package Ch09_ExceptionHandling;

/**
 * Created by Ross on 21.08.2017.
 */
public class CustomExcept {
    public static void main(String[] args) {
        int numer[] = { 4, 8, 15, 32, 64, 127, 256, 512 };
        int denom[] = { 2, 0, 4, 4, 0, 8 };
        for (int i = 0; i < numer.length; i++) {
            try {
                if ((numer[i]%2 != 0)) {
                throw new NonIntResultException(numer[i],denom[i]);
                }

                System.out.println(numer[i] + " / " + denom[i] + " = " + numer[i]/denom[i]);
            }
            catch (ArithmeticException exc){
                System.out.println("Попытка делить на ноль");
                System.out.println(exc);
            }
            catch (ArrayIndexOutOfBoundsException exc){
                System.out.println("Соответсвующий элемент не найден");
                System.out.println(exc);
            }
            catch (NonIntResultException exc){
                System.out.println(exc);
            }

        }
    }
}

class NonIntResultException extends Exception{
    private int n;
    private int d;

    NonIntResultException(int i, int j){
        n = i;
        d = j;
    }

    @Override
    public String toString() {
        return "Результат операции " + n + " / " + d + " не является целым числом";
    }
}