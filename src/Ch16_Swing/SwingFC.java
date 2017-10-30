package Ch16_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ross on 30.10.2017.
 */

public class SwingFC implements ActionListener {
    JTextField jtfFirst; //имя первого файла
    JTextField jtfSecond; //имя второго файла

    JButton jbtnComp;

    JLabel jlabFirst, jlabSecond; //метки, отображ подсказки
    JLabel jlabResult; //метка для отображения результата сравнения и сооб. об ошибках

    JCheckBox jcbLoc;

    SwingFC() {
        JFrame jfrm = new JFrame("Compare files");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 190);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtfFirst = new JTextField(14);
        jtfSecond = new JTextField(14);

        jtfFirst.setActionCommand("fileA");
        jtfSecond.setActionCommand("fileB");

        jbtnComp = new JButton("Compare");
        jbtnComp.addActionListener(this);

        //метки
        jlabFirst = new JLabel("First file: ");
        jlabSecond = new JLabel("Second file: ");
        jlabResult = new JLabel("");

        jcbLoc = new JCheckBox("Show position of mismatch");

        jfrm.add(jlabFirst);
        jfrm.add(jtfFirst);
        jfrm.add(jlabSecond);
        jfrm.add(jtfSecond);
        jfrm.add(jcbLoc);
        jfrm.add(jbtnComp);
        jfrm.add(jlabResult);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0, j = 0;
        int count = 0;
        if (jtfFirst.getText().equals("")) {
            jlabResult.setText("First file name missing.");
            return;
        }
        if (jtfSecond.getText().equals("")) {
            jlabResult.setText("Second file name missing.");
            return;
        }

        try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
             FileInputStream f2 = new FileInputStream(jtfSecond.getText())) {
            do {
                i = f1.read();
                j = f2.read();
                if (i != j) break;
                count++;
            } while (i != -1 && j != -1);

            if (i != j) {
                if (jcbLoc.isSelected())
                    jlabResult.setText("Files differ at location " + count);
                else
                    jlabResult.setText("Files are not the same.");
            } else
                jlabResult.setText("Files compare equal");
        } catch (IOException exc) {
            jlabResult.setText("File Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingFC());
    }
}
