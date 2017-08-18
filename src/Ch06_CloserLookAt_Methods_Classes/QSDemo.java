package Ch06_CloserLookAt_Methods_Classes;

/**
 * Created by Ross on 18.08.2017.
 */
class QSDemo {
    public static void main(String[] args) {
        char a[] = {'d','x','a','r','q','w','j'};

        System.out.print("Исходный массив: ");
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i]+" ");
        }

        System.out.println();

        QuickSort.qsort(a);
        System.out.print("Сортированный массив: ");
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
