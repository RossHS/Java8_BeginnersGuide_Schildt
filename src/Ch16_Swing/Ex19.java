package Ch16_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ross on 30.10.2017.
 */
public class Ex19 implements ActionListener {

    private JList<String> jlst;
    private JButton jbtn;
    private JScrollPane jsrll;
    private JLabel jlab;
    private JTextArea jtextArea;

    private String selectedField = "";
    private String loop[] = {"for", "foreach", "while", "do...while", "switch"};

    private Ex19() {
        JFrame frame = new JFrame("EX9");
        frame.setLayout(new FlowLayout());
        frame.setSize(260, 260);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        jlst = new JList<>(loop);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jsrll = new JScrollPane(jlst);
        jsrll.setPreferredSize(new Dimension(120, 90));
        jlab = new JLabel("Выберите цикл");
        jbtn = new JButton("Показать");
        jtextArea = new JTextArea(5, 23);
        jtextArea.setEditable(false);
        jtextArea.setLineWrap(true);

        jbtn.addActionListener(this);

        frame.add(jsrll);
        frame.add(jbtn);
        frame.add(jlab);
        frame.add(jtextArea);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jlst.isSelectionEmpty()) {
            selectedField = jlst.getSelectedValue();
            switch (selectedField) {
                case "for":
                    jtextArea.setText("Цикл for: ");
                    jtextArea.append("\nfor(инициaлизaция; условие; итерация)");
                    jtextArea.append("\n   оператор");
                    break;
                case "foreach":
                    jtextArea.setText("Цикл foreach:");
                    jtextArea.append("\n");
                    break;
                case "while":
                    jtextArea.setText("Цикл while:");
                    jtextArea.append("\nwhile(условие) оператор");
                    break;
                case "do...while":
                    jtextArea.setText("Цикл do...while:");
                    jtextArea.append("\ndo {");
                    jtextArea.append("\n  оператор;");
                    jtextArea.append("\n} while (условие)");
                    break;
                case "switch":
                    jtextArea.setText("Oпepaтop switch:\n");
                    jtextArea.append("switch (выражение} { ");
                    jtextArea.append("\n case константа:");
                    jtextArea.append("\n последовательность операторов");
                    jtextArea.append("\n break;");
                    jtextArea.append("\n // ... ");
                    jtextArea.append("\n}");
                    break;
                default:
                    System.out.println("незарегистрированный цикл");
                    break;
            }
        } else jtextArea.setText("Вы не выбрали цикл");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex19());
    }
}
