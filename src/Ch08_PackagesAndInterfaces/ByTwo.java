package Ch08_PackagesAndInterfaces;

/**
 * Created by Ross on 20.08.2017.
 */
public class ByTwo implements Series {
    int start;
    int val;
    int prev;

    public ByTwo(){
        start = 0;
        val = 0;
        prev = -2;
    }
    @Override
    public int getNext() {
        prev = val;
        val += 2;
        return val;
    }

    @Override
    public void reset() {
        start = 0;
        val = 0;
        prev = -2;
    }

    @Override
    public void setStart(int x) {
        start = x;
        val = x;
        prev = x - 2;
    }

    int getPrev() {
        return prev;
    }
}
