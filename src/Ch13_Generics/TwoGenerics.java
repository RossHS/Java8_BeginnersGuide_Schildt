package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
public class TwoGenerics<T, V> {
    T ob1;
    V ob2;

    TwoGenerics(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    void showType() {
        System.out.println("Тип Т - это " + ob1.getClass().getName());
        System.out.println("Тип V - это " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}

class SimplGen {
    public static void main(String[] args) {
        TwoGenerics<Integer, String> tgObj = new TwoGenerics<Integer, String>(88, "Обобщения");

        tgObj.showType();

        int t = tgObj.getOb1();
        System.out.println("Значение: " + t);

        String str = tgObj.getOb2();
        System.out.println("Значение: " + str);

        //или можно так
        TwoGenerics<String, String> tgStr = new TwoGenerics<String, String>("123", "asdf");
    }
}
