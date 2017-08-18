package Ch06_CloserLookAt_Methods_Classes;

/**
 * Created by Ross on 18.08.2017.
 */
public class Test {
    int a;
    Test(int i){
        a = i;
    }
    void swap(Test obj1, Test obj2){
        int x;
        x = obj1.a;
        obj1.a = obj2.a;
        obj2.a = x;
    }
}
