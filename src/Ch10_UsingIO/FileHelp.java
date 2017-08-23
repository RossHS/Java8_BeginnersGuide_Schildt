package Ch10_UsingIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ross on 23.08.2017.
 */
public class FileHelp {
    public static void main(String[] args) {
        Help hlp = new Help("src/Ch10_UsingIO/helpfile.txt");
        String topic;

        System.out.println("Воспользуйтесь справочной системой.\n" + "Для выхода из системы введите 'stop'.");

        do {
            topic = hlp.getSelection();
            if(!hlp.helpon(topic))
                System.out.println("Тема не найдена.\n");

        } while (topic.compareTo("stop") != 0);
    }
}

class Help {
    String helpfile;

    Help(String fname) {
        helpfile = fname;
    }

    //Отображает справочную информацию по указанной теме
    boolean helpon(String what) {
        int ch;
        String topic, info;

        try (BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile))) {
            do {
                ch = helpRdr.read();
                if (ch == '#') {
                    topic = helpRdr.readLine();
                    if (what.compareTo(topic) == 0) {
                        do {
                            info = helpRdr.readLine();
                            if (info != null) System.out.println(info);
                        } while ((info != null) && (info.compareTo("") != 0));
                        return true;
                    }
                }
            } while (ch != -1);

        } catch (IOException e) {
            System.out.println("Ошибка при попытке доступа к файлу справки");
            return false;
        }
        return false;
    }

    //получить тему справки
    String getSelection() {
        String topic = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Укажите тему: ");
        try {
            topic = br.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении с консоли");
        }
        return topic;
    }
}
