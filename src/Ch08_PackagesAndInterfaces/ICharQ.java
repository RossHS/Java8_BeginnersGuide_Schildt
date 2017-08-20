package Ch08_PackagesAndInterfaces;

/**
 * Created by Ross on 20.08.2017.
 */
//Интерфейс для очереди символов
public interface ICharQ {
    //Поместить символ в очередь
    void put(char ch);

    //Извлечь символ из очереди
    char get();

    //Сбросить очередь
    void reset();
}
