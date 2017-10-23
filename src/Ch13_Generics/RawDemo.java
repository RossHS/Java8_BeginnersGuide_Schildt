package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
public class RawDemo {
    public static void main(String[] args) {
        //создаем объект класса Generic для типа Integer
        Generic<Integer> iOb = new Generic<Integer>(88);

        //теперь создадим базовый(сырой) объект класса и передадим ему знач типа Double
        //так как мы не указали аргумент типа дженерика T, ему автоматически присвоился Object
        Generic raw = new Generic(new Double(12.1));

        //Здесь требуется приведение типов, так как тип неизвестен
        double d = (Double) raw.getOb();
        System.out.println("Значение " + d);

        iOb = raw; //Допустимо, но потенциально не верно, безопасность испл типа не проверяется
    }
}
