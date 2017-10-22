package Ch12_Enum_Autobox_StaticImport_Annotations;

/**
 * Created by Ross on 22.10.2017.
 */
@Deprecated
public class DeprecatedClass {
    private String msg;

    DeprecatedClass(String m){
        msg = m;
    }

    @Deprecated
    String getMsg(){
        return msg;
    }
}
class AnnoDemo{
    public static void main(String[] args) {
        DeprecatedClass myObj = new DeprecatedClass("12345");
        System.out.println(myObj.getMsg());
    }
}
