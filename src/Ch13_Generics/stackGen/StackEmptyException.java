package Ch13_Generics.stackGen;

/**
 * Created by Ross on 24.10.2017.
 */
public class StackEmptyException extends Exception {
    @Override
    public String toString() {
        return "\nСтек пуст";
    }
}
