package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 27.10.2017.
 */
public interface MyIntPredicate {
    boolean test(MyIntNumber mv, int n);
}

class MyIntNumber {
    private int v;

    MyIntNumber(int x) {
        v = x;
    }

    int getNum() {
        return v;
    }

    boolean isFactor(int n) {
        return (v % n) == 0;
    }

    public static void main(String[] args) {
        boolean result;

        MyIntNumber myNum = new MyIntNumber(12);
        MyIntNumber myNum2 = new MyIntNumber(16);

        //ссылка на метод любого объекта типа MyIntPredicate
        MyIntPredicate inp = MyIntNumber::isFactor;

        result = inp.test(myNum, 3);
        if (result)
            System.out.println("3 является делителем " + myNum.getNum());

        result = inp.test(myNum2, 3);
        if (!result)
            System.out.println("3 не является делителем " + myNum2.getNum());
    }
}


