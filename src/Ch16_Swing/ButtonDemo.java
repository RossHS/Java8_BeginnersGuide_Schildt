package Ch16_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ross on 29.10.2017.
 */
public class ButtonDemo implements ActionListener {
    JLabel jlab;

    ButtonDemo() {
        JFrame frame = new JFrame("A Button Example");
        //задаем объект для менеджера компоновки
        frame.setLayout(new FlowLayout());
        frame.setSize(220, 90);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jbUp = new JButton("UP");
        JButton jbDown = new JButton("DOWN");

        //добавим им слушателя
        jbUp.addActionListener(this);
        jbDown.addActionListener(this);

        //добавить кнопки в панель содержимого
        frame.add(jbUp);
        frame.add(jbDown);

        jlab = new JLabel("Press a button.");
        frame.add(jlab);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("UP"))
            jlab.setText("You pressed Up.");
        else
            jlab.setText("You pressed Down.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ButtonDemo());
    }
}
