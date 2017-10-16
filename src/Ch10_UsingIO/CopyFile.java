package Ch10_UsingIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ross on 16.10.2017.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        int i;


        try (FileInputStream fin = new FileInputStream("src/Ch10_UsingIO/testCopyFrom.txt");
             FileOutputStream fout = new FileOutputStream("src/Ch10_UsingIO/testCopyTo.txt")) {
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}

