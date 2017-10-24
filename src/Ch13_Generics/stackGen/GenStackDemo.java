package Ch13_Generics.stackGen;

/**
 * Created by Ross on 24.10.2017.
 */
public class GenStackDemo {
    public static void main(String[] args) {
        //Пустой стек
        GenStack<Integer> iGs = new GenStack<>(new Integer[10]);

        //стек из массива
        String name[] = {"ONE","TWO","THREE"};
        String strStore[] = new String[3];
        GenStack<String> strGs = new GenStack<String>(strStore,name);

        String str;
        int n;
        try{
            for (int i = 0; i < 10 ; i++) {
                iGs.push(i);
            }
        }catch (StackFullException exc){
            System.out.println(exc);
        }

        //создадим стек один из другого
        String strStore2[] = new String[3];
        GenStack<String> strGs2 = new GenStack<String>(strStore2,strGs);


        //отобразить стеки
        try{
            System.out.print("Содержимое стека Integer: ");
            for (int i = 0; i < 10 ; i++) {
                n = iGs.pop();
                System.out.print(n + " ");
            }
        } catch (StackEmptyException exc){
            System.out.println(exc);
        }

        System.out.println("\n");

        try{
            System.out.print("Содержимое стека String: ");
            for (int i = 0; i < 3 ; i++) {
                str = strGs.pop();
                System.out.print(str + " ");
            }
        } catch (StackEmptyException exc){
            System.out.println(exc);
        }

        System.out.println("\n");

        try{
            System.out.print("Содержимое стека String2: ");
            for (int i = 0; i < 3 ; i++) {
                str = strGs2.pop();
                System.out.print(str + " ");
            }
        } catch (StackEmptyException exc){
            System.out.println(exc);
        }
        System.out.println();
    }
}
