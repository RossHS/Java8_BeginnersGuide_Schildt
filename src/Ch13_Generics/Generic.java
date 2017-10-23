package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
public class Generic<T> {
    T ob;

    Generic(T o){
        ob = o;
    }

    T getOb(){
        return ob;
    }

    void showType(){
        System.out.println("Тип T - это " + ob.getClass().getName());
    }
}
class GenDemo{
    public static void main(String[] args) {
        //Автоупакуем 100, можно сделать и так new Integer(100)
        Generic<Integer> iOb = new Generic<Integer>(100);

        //отобразим тип данных, используемых в объекте iOb
        iOb.showType();
        int v = iOb.getOb();
        System.out.println("Значение " + v);

        System.out.println();

        Generic<String> strOb = new Generic<String>("ТЕСТ");

        strOb.showType();
        String str = strOb.getOb();
        System.out.println("Значение " + str);

    }
}