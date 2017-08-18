package Ch06_CloserLookAt_Methods_Classes;

/**
 * Created by Ross on 18.08.2017.
 */
public class Recursion {
    private String text ;
    Recursion(String str){
        text = str;
    }

    public static void main(String[] args) {
        Recursion rec = new Recursion("ПРИВЕТ");
        rec.rec(0);
        System.out.println();
        rec.notRec();
    }

    void rec(int a) {
        if (a != text.length() - 1) rec(a + 1);
        System.out.print(text.charAt(a));
    }

    void notRec() {
        for (int i = text.length()-1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }
    }
}

