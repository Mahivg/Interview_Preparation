package inheritance;

public class Circle extends Shape{
    public static String NAME = "CIRCLE";

    public Circle(){
        System.out.println(" Circle Constructor");;
    }

    public void draw(){
        System.out.println(" draw(): Circle ");
    }

    public static void drawShape(){
        System.out.println(" drawShape() : Circle ");
    }



}
