package Ch05_MoreDataTypes_Operators;

/**
 * Created by Ross on 17.08.2017.
 */
public class Encode {
    public static void main(String[] args) {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        String key = "abcdefgi";
        int j;

        System.out.print("Исходное сообщение: ");
        System.out.println(msg);

        //шифруем его
        j = 0;
        for (int i = 0; i < msg.length(); i++) {
            encmsg += (char) (msg.charAt(i) ^ key.charAt(j));
            j++;
            if (j == 8){
                j = 0;
            }
        }
        System.out.print("Зашифрованное сообщение: ");
        System.out.println(encmsg);

        //Дешифровка
        j = 0;
        for (int i = 0; i < msg.length(); i++) {
            decmsg += (char) (encmsg.charAt(i) ^ key.charAt(j));
            j++;
            if (j == 8){
                j = 0;
            }
        }
        System.out.print("Дешифрованное сообщение: ");
        System.out.println(decmsg);

    }
}
