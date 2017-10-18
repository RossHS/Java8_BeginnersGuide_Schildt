package Ch10_UsingIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ross on 18.10.2017.
 */
public class CopyFilesEx7 {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream("src/Ch10_UsingIO/Ex7From.txt");
            fout = new FileOutputStream("src/Ch10_UsingIO/Ex7To.txt");

            do {
                i = fin.read();
                //Заменяем пробел на дефис
                if ((char) i == ' ') i = '-';
                if (i != -1) fout.write(i);
            } while (i != -1);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
