package Ch04_Intro_Classes_Objects_Methods;

/**
 * Created by Ross on 16.08.2017.
 */
class Finalize {
    Finalize() {
    }

    public static void main(String[] args) {
        FDemo obj = new FDemo(0);

        for(int count = 1; count < 1000000000; ++count) {
            obj.generator(count);
        }

    }
}
class FDemo {
    int x;

    FDemo(int i) {
        this.x = i;
    }

    protected void finalize() {
        System.out.println("Финализация " + this.x);
    }

    void generator(int i) {
        new FDemo(i);
    }
}

