package Ch15_Applets_Events;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Ross on 28.10.2017.
 */
public class MouseEvents extends Applet implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0, mouseY = 0;//Координаты указателя мыши

    @Override
    public void init() {
        //Регестрация этого класса в качестве слушателя событий мыши
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    //обработка событий щелчка мышью
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = 0;
        mouseY = 0;
        msg = "Mouse clicked.";
        repaint();
    }

    //Обработчик события нажатия кнопки мыши
    @Override
    public void mousePressed(MouseEvent e) {
        //сохранить координаты
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Down";
        repaint();
    }

    //отпускание мыши
    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*";
        showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
        repaint();
    }

    //Обработчик событий наведения указателя на область элемента
    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse entered.";
        repaint();
    }

    //обработчик события выхода указателя за пределы элемента
    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse exited";
        repaint();
    }

    //Обработчик события перетаскивания указателя мыши
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*";
        showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        showStatus("Moving mouse at " + e.getX() + ", " + e.getY());
    }

    //отобразить значение в окне аплета
    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }
}
