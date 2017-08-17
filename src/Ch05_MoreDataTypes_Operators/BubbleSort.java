package Ch05_MoreDataTypes_Operators;

import sun.font.FontRunIterator;

/**
 * Created by Ross on 17.08.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int nums[] = {1212,13,-42,12,1634,-19999};
        int t;
        System.out.print("Исходный массив:");

        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
        //Сортировка пузырьком
        for (int i = 1; i < nums.length ; i++) {
            for (int j = nums.length - 1; j >= i ; j--) {
                if (nums[j-1] > nums[j]){
                    t = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = t;
                }
            }
        }

        System.out.print("Отсортированный массив:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }
}
