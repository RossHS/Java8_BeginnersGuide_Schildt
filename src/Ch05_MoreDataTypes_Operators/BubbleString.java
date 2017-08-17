package Ch05_MoreDataTypes_Operators;

/**
 * Created by Ross on 17.08.2017.
 */
public class BubbleString {
    public static void main(String[] args) {
        String str[] = {"abcd","ara","puke","this","is","the","end"};
        String t;
        System.out.print("Исходный массив:");

        for (int i = 0; i < str.length; i++) {
            System.out.print(" " + str[i]);
        }
        System.out.println();
        //Сортировка пузырьком
        for (int i = 1; i < str.length ; i++) {
            for (int j = str.length - 1; j >= i ; j--) {
                if (str[j-1].compareTo(str[j]) > 0){
                    t = str[j-1];
                    str[j-1] = str[j];
                    str[j] = t;
                }
            }
        }

        System.out.print("Отсортированный массив:");
        for (int i = 0; i < str.length; i++) {
            System.out.print(" " + str[i]);
        }
        System.out.println();
    }
}
