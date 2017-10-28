package Ch15_Applets_Events;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by Ross on 28.10.2017.
 */

//Создается поток, управляющий прокруткой текста сообщений
//хранящегося в переменной msg, справа налево в окне аплета
public class Banner extends Applet implements Runnable {
    String msg = "Java rules the world";
    Thread thrd;
    boolean stopFlag;

    @Override
    public void init() {
        thrd = null;
    }

    //запустить поток
    @Override
    public void start() {
        thrd = new Thread(this);
        stopFlag = false;
        thrd.start();
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                repaint();
                Thread.sleep(250);
                if (stopFlag) {
                    break;
                }
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    //приостановить выполнение аплета
    @Override
    public void stop() {
        stopFlag = true;
        thrd = null;
    }

    //отобразить баннер
    @Override
    public void paint(Graphics g) {
        showStatus("This is show status window");
        char ch;
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        g.drawString(msg, 50, 30);
    }
}
