package Ch13_Generics.stackGen;

/**
 * Created by Ross on 24.10.2017.
 */
public interface IGenStack<T> {
    void push(T obj) throws StackFullException;
    T pop() throws StackEmptyException;
}
