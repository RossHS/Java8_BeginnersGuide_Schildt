package Ch15_Applets_Events;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by Ross on 28.10.2017.
 */
/*
    <applet code ="SimpleApplet" width = 200 height =60>
    </applet>
 */
public class SimpleApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Java makes applets easy", 20, 20);
    }
}
