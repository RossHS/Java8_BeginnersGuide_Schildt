package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
public class UseBoundedWildcard {

    //В качестве допустимого типа параметр принимает обобщения типа А
    //и его подклассы
    static void test(Generic<? extends A> o) {

    }

    //можно использовать в качества аргумента
    static void testSuper(Generic<? super C> o) {

    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        Generic<A> w1 = new Generic<A>(a);
        Generic<B> w2 = new Generic<B>(b);
        Generic<C> w3 = new Generic<C>(c);
        Generic<D> w4 = new Generic<D>(d);

        test(w1);
        test(w2);
        test(w3);
        //Объект w4 не относится к подклассу A.
        //test(w4); //Ошибка!

        testSuper(w3);
        testSuper(w1);

        //testSuper(w2); Ошибка, так как он не имеет отношения к иерархии класса С
    }
}

class A {

}

class B extends A {

}

class C extends A {

}

class D {

}