package Ch12_Enum_Autobox_StaticImport_Annotations;

/**
 * Created by Ross on 22.10.2017.
 */
public class Ex3 {
    public static void main(String[] args) {
        for (Tools tools : Tools.values()) {
            System.out.println("Инструмент " + tools + " имеет порядок" + tools.ordinal());
        }
    }
}

enum Tools {
    SCREWDRIVER, WRENCH, HAMMER, PLIERS
}