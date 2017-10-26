package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 26.10.2017.
 */
public class LambdaDemo {
    public static void main(String[] args) {

        //Просто константа. При его назначении
        //переменной myVal создается
        //экземпляр класса, в котором лямбда-выражение
        //реализует метод getValue() интерфейса
        MyValue myValue = () -> 98.6;
        System.out.println("Постоянное значение: " + myValue.getValue());

        MyParamValue myPval = (n) -> 1.0 / n;
        System.out.println("Обратная величина 4 " + myPval.getValue(4));
        System.out.println("Обратная величина 10 " + myPval.getValue(10));

        //Лямбда-выражения должны быть совместимы с методом,
        //который определяет функциональный интерфейс. По-этому
        //эти два выражение не сработают
        //myValue = () -> "three"; //возвращаем стринг
        //myPval = () -> Math.random(); //нет аргумента
    }
}
