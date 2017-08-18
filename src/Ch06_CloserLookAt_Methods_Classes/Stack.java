package Ch06_CloserLookAt_Methods_Classes;

/**
 * Created by Ross on 18.08.2017.
 */
public class Stack {
    private char q[];
    private int tos;

    Stack(int size){
        q = new char[size];
        tos= 0;
    }

    void set(char ch){
        q[tos] = ch;
        tos++;
    }

    char get() {
        tos--;
        return q[tos];
    }
}
