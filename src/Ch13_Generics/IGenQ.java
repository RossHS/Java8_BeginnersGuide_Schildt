package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
public interface IGenQ<T> {
    void put(T obj) throws QueueFullException;
    T get() throws QueueEmptyException;
}
