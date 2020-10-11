package inheritance;

public class Shape {

    public static String NAME = "SHAPE";
    Shape(){
        System.out.println(" Shape Constructor is called ");
    }

    public void draw(){
        System.out.println(" draw() : Shape ");
    }

    public static void drawShape(){
        System.out.println(" drawShape() : Shape ");
    }

}
