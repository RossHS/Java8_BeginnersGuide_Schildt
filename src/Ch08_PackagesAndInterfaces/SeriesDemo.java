package Ch08_PackagesAndInterfaces;

/**
 * Created by Ross on 20.08.2017.
 */
public class SeriesDemo {
    public static void main(String[] args) {
        ByTwo obj = new ByTwo();

        for (int i = 0; i < 5; i++) {
            System.out.println("Следущее значение: " + obj.getNext());
        }

        System.out.println("\nСброс");
        obj.reset();
        for (int i = 0; i < 5; i++) {
            System.out.println("Следущее значение: " + obj.getNext());
        }

        System.out.println("\nНачальное значение: 100");
        obj.setStart(100);
        for (int i = 0; i < 5; i++){
            System.out.println("Следущее знчение: " + obj.getNext());
        }
    }
}
