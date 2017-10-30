package Ch16_Swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by Ross on 30.10.2017.
 */
public class ListDemo implements ListSelectionListener {
    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;

    String names[] = {"Sherry", "Jon", "Rachel", "Sasha",
            "Josselyn", "Randy", "Тот", "Mary",
            "Ken", "Andrew", "Matt", "Todd"};

    ListDemo() {
        JFrame jfrm = new JFrame("JList Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 160);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //создали объект JList
        jlst = new JList<>(names);
        //режим выбора одиночных элементов
        //  jlst.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //прокрутка
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(120, 90));
        jlab = new JLabel("Please choose a name");
        jlst.addListSelectionListener(this);

        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
        jfrm.setResizable(false);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //получаем индекс элемента состояние выбора
        //которого было изменено
        // int idx = jlst.getSelectedIndex();
        int indices[] = jlst.getSelectedIndices();
        if (indices.length != 0) {
            String who = "";
            for (int i : indices) {
                who += names[i] + " ";
                jlab.setText("Current selections: " + who);
            }
        }else
            jlab.setText("Please choose a name");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListDemo());
    }
}
