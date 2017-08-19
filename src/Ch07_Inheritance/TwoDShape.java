package Ch07_Inheritance;

/**
 * Created by Ross on 19.08.2017.
 */
public class TwoDShape {
}
class Circle extends TwoDShape{
    private double radius;
    Circle(double r){
        super();
        radius = r;
    }
    double area(){
        return Math.PI*Math.pow(radius,2);
    }
}
class Test{
    public static void main(String[] args) {
        Circle circ = new Circle(10);
        System.out.println(circ.area());
    }
}