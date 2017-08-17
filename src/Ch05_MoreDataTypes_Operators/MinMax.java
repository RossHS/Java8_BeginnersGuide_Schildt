package Ch05_MoreDataTypes_Operators;

/**
 * Created by Ross on 17.08.2017.
 */
public class MinMax {
    public static void main(String[] args) {
        int num[] = {99,1999,1324,-213,452,325,15555,-11111111,1124};

        int min =  num [0];
        int max = num[0];

        for (int x: num){
            if(x < min){
                min = x;
            }
            if (x > max){
                max = x;
            }
        }
        System.out.println(max +" "+ min);
    }
}
