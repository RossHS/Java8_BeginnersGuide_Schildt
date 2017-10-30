package Ch16_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Ross on 30.10.2017.
 */
public class CBDemo implements ItemListener {
    JLabel jlabSelected;
    JLabel jlabChanged;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;

    CBDemo() {
        JFrame jfrm = new JFrame("Check Boxes");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(280, 120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");

        jcbAlpha = new JCheckBox("Alpha");
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");

        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);

        jfrm.add(jcbAlpha);
        jfrm.add(jcbBeta);
        jfrm.add(jcbGamma);
        jfrm.add(jlabChanged);
        jfrm.add(jlabSelected);

        jfrm.setVisible(true);
    }

    //обработчик для флажков
    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = "";

        //получить ссылку на флажок, с которым связано событие
        JCheckBox cb = (JCheckBox) e.getItem();

        if (cb.isSelected())
            jlabChanged.setText(cb.getText() + " was just selected");
        else
            jlabChanged.setText(cb.getText() + " was just cleared.");

        if (jcbAlpha.isSelected()) {
            str += "Alpha ";
        }
        if (jcbBeta.isSelected()) {
            str += "Beta ";
        }
        if (jcbGamma.isSelected()) {
            str += "Gamma ";
        }
        jlabSelected.setText("Selected check boxes: " + str);
        if (!jcbAlpha.isSelected() && !jcbBeta.isSelected() && !jcbGamma.isSelected()) {
            jlabSelected.setText("");
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CBDemo());
    }
}
