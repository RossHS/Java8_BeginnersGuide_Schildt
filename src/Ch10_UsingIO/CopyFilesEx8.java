package Ch10_UsingIO;

import java.io.*;

/**
 * Created by Ross on 18.10.2017.
 */
public class CopyFilesEx8 {
    public static void main(String[] args) {
        int i;
        try (FileReader fin = new FileReader("src/Ch10_UsingIO/Ex7From.txt");
             FileWriter fout = new FileWriter("src/Ch10_UsingIO/Ex7To.txt")) {
            do {
                i = fin.read();
                //Заменяем пробел на дефис
                if ((char) i == ' ') i = '-';
                if (i != -1) fout.write(i);
            } while (i != -1);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
