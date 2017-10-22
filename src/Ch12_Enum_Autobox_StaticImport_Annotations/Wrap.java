package Ch12_Enum_Autobox_StaticImport_Annotations;

/**
 * Created by Ross on 22.10.2017.
 */
public class Wrap {
    public static void main(String[] args) {
        Integer iOb = new Integer(50);
        int num = iOb.intValue();
        System.out.println(num + " " + iOb);
    }
}
