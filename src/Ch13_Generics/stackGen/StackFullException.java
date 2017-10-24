package Ch13_Generics.stackGen;

/**
 * Created by Ross on 24.10.2017.
 */
public class StackFullException extends Exception {
    int size;
    StackFullException(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "\nСтек заполнен. Максимальный размер стека: " + size;
    }
}
