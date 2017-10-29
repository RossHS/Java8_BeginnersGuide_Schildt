package Ch16_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ross on 29.10.2017.
 */
public class TFDemo implements ActionListener {

    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;

    TFDemo() {
        JFrame jfrm = new JFrame("Use a Text Field");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(240, 120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ширина 10 символов
        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");

        JButton jbtnRev = new JButton("Reverse");

        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        //метки
        jlabPrompt = new JLabel("Enter text: ");
        jlabContents = new JLabel("");

        jfrm.add(jlabPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabContents);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reverse")) {
            String orgStr = jtf.getText();
            String resStr = "";

            //Обработать строку в текстовом поле
            for (int i = orgStr.length() - 1; i >= 0; i--) {
                resStr += orgStr.charAt(i);
            }

            jtf.setText(resStr);
        } else {
            jlabContents.setText("You pressed ENTER. Text is: " + jtf.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TFDemo());
    }
}
