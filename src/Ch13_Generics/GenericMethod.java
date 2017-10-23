package Ch13_Generics;

/**
 * Created by Ross on 23.10.2017.
 */
//пример простого обобщенного метода
public class GenericMethod {

    //Определить, совпадает ли содержимое двух массивов
    static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] x, V[] y) {
        //Generic метод
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer nums1[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        if (arraysEqual(nums1, nums1)) {
            System.out.println("nums1 эквивалентен nums1");
        }
        if (arraysEqual(nums1, nums2)) {
            System.out.println("nums1 эквивалентен nums2");
        }
        if (arraysEqual(nums1, nums3)) {
            System.out.println("nums1 эквивалентен nums3");
        }
        if (arraysEqual(nums1, nums4)) {
            System.out.println("nums1 эквивалентен nums4");
        }

        Double dvals[] = {1.2, 122.1, 3.4, 2.3};
        //Следующая строка не будет скомпилирована, так как типы массивов
        //nums и dvals не совпадают
        //if(arraysEqual(nums1,dvals))
    }
}
