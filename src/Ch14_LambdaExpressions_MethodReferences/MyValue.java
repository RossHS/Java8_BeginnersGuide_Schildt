package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 26.10.2017.
 */
//для лямбда-выражений требуется функциональный интерфейс
//т.е. так, где есть 1 абстрактный метод, (не важно сколько будет
//статических методом и дефолтных в интерфейсе)
public interface MyValue {
    double getValue();
}
