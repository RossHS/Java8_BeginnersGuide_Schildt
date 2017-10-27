package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
interface MyFunc {
    MyClass func(String s);
}

class MyClass {
    private String str;

    //вызываться будет он, так как сигнатура идентична функц интерфейсу
    MyClass(String str) {
        this.str = str;
    }

    MyClass(){
        str = "";
    }
    String getStr(){
        return str;
    }
}

public class ConstructorRef {
    public static void main(String[] args) {
        //создадим ссылку на конструктор MyClass
        //послкольку метод func() интерфейса принимает аргумент
        //new ссылается на параметризированный конструктор MyClass
        //а не на конструктор по умолчанию
        MyFunc myClassCons = MyClass::new;

        MyClass mc = myClassCons.func("ТЕСТ");

        System.out.println(mc.getStr());
    }
}
