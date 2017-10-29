package Ch16_Swing;

import javax.swing.*;

/**
 * Created by Ross on 29.10.2017.
 */
public class SwingDemo {
    SwingDemo() {
        JFrame frame = new JFrame("Tittle Swing");
        frame.setSize(275, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlab = new JLabel("Swing defines the moderns GUI.");
        frame.add(jlab); //добавить метку в контейнер верхнего уровня
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //создаем фрейм в потоке диспетчеризации событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
