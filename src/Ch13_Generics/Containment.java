package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
//Подразумевает, что класс, реализующий интерфейс
//содержит одно или несколько значений
public interface Containment<T extends Number> {
    //метож проверяет, содержится ли
    //некоторые элементы в объекте класса
    //реализующие этот интерфейс
    boolean contains(T o);
}

//Реализуем интерфейс с помощью массива
//предназначенного для хранения значений
//class MyClass implements Containment<T> не сработает
class MyClass<T extends Number> implements Containment<T> {
    T[] arrayRef;

    public MyClass(T[] arrayRef) {
        this.arrayRef = arrayRef;
    }

    @Override
    public boolean contains(T o) {
        for (T x : arrayRef) {
            if (x.equals(o)) return true;
        }
        return false;
    }
}

class GenIFDemo {
    public static void main(String[] args) {
        Integer x[] = {1, 2, 3};

        MyClass<Integer> ob = new MyClass<Integer>(x);

        if (ob.contains(2)) {
            System.out.println("2 содержится в ob");
        } else System.out.println("2 Не содержится в ob");
        if (ob.contains(5)) {
            System.out.println("5 содержится в ob");
        } else System.out.println("5 Не содержится в ob");

        //if (ob.contains(9.25)) недопустимо, так как интерфейс реализован для Integer, а не Double
    }
}
