package Ch12_Enum_Autobox_StaticImport_Annotations;

/**
 * Created by Ross on 22.10.2017.
 */

enum TrafficLightColor {
    RED(12_000), GREEN(10_000), YELLOW(2_000);
    private int delay;

    TrafficLightColor(int d) {
        delay = d;
    }

    int getDelay(){
        return delay;
    }
}

public class TrafficLight {
    public static void main(String[] args) {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);

        for (int i = 0; i < 9; i++) {
            System.out.println(t1.getColor());
            t1.waitForChange();
        }
        t1.cancel();
    }
}

class TrafficLightSimulator implements Runnable {
    private Thread thrd; //поток для имитации светофора
    private TrafficLightColor tlc; //текущий цвет светофора
    boolean stop = false; //для остановки имитации установить true
    boolean changed = false; //true, если светофор переключился

    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;

        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;

        thrd = new Thread(this);
        thrd.start();
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(tlc.getDelay());
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            changeColor();
        }
    }

    synchronized void changeColor() {
        switch (tlc) {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }
        changed = true;
        notify();
    }

    synchronized void waitForChange() {
        try {
            while (!changed)
                wait();
            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    TrafficLightColor getColor() {
        return tlc;
    }

    void cancel() {
        stop = true;
    }
}
