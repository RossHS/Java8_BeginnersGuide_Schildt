package Ch05_MoreDataTypes_Operators;

/**
 * Created by Ross on 17.08.2017.
 */
public class Average {
    public static void main(String[] args) {
        double[] d = {1,2,4,6};
        double sum = 0;

        System.out.print("Среднее арифмитическое массива: ");
        for (double x: d){
            System.out.print(x + " ");
        }

        for (double x: d) {
            sum += x;
        }
        System.out.println("\nРавно = " + sum/d.length);
    }
}
