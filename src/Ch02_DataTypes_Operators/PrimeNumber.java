package Ch02_DataTypes_Operators;

/**
 * Created by Ross on 14.08.2017.
 */
public class PrimeNumber {
    public static void main(String[] args) {
    int divisor;
    String prime = "";
        for (int i = 2; i < 100 ; i++) {
            divisor = 0;
            for (int j = 1; j <= i; j++) {
                if (i%j == 0){
                    divisor++;
                }
            }
            if (divisor == 2){
                prime += i + ", ";
            }
        }
        System.out.println(prime);
    }
}
