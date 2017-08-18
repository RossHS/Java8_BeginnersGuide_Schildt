package Ch06_CloserLookAt_Methods_Classes;

/**
 * Created by Ross on 18.08.2017.
 */
public class SumA {
    int sum(int ... x){
        int result = 0;
        for (int i = 0; i < x.length ; i++) {
            result += x[i];
        }
        return result;
    }
}
class SumaTest{
    public static void main(String[] args) {
        SumA test = new SumA();
        int result = test.sum(1,2,4);
        System.out.println(result);
        result = test.sum(1,2,3,4,5);
        System.out.println(result);
    }
}
