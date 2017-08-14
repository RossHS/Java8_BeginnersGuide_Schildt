package Ch02_DataTypes_Operators;

/**
 * Created by Ross on 14.08.2017.
 */

public class LogicalOpTable1_0 {
    //Заменить значения true и false на 1 и 0;
    static int toInt(boolean x){
        return x ? 1:0;
    }
    static void table(boolean p, boolean q) {
        System.out.print(toInt(p) + "\t" + toInt(q) + "\t");
        System.out.print(toInt(p&q) + "\t" + toInt(p|q) + "\t");
        System.out.println(toInt(p^q) + "\t" + toInt(!p));
    }

    public static void main(String[] args) {
        boolean p, q;
        System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");

        p = true;
        q = true;
        table(p,q);

        p = true;
        q = false;
        table(p,q);

        p = false;
        q = true;
        table(p,q);

        p = false;
        q = false;
        table(p,q);
    }
}
