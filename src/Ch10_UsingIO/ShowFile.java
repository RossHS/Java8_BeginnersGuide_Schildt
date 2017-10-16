package Ch10_UsingIO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ross on 16.10.2017.
 */
public class ShowFile {
    public static void main(String[] args) {
        int i;
        try (FileInputStream fin = new FileInputStream("src/Ch10_UsingIO/testSF.txt");) {

            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
