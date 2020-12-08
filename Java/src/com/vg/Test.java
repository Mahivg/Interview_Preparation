package com.vg;


import com.vg.inheritance.Circle;
import com.vg.inheritance.Shape;

public class Test {


        public static void main(String[] args){

            Shape s = new Circle();
            Circle c1 = new Circle();
            s.draw();
            s.drawShape();
//            Not possible because parent reference doesn't have access to child specific method
//            s.sketch();
            Shape.drawShape();
            System.out.println(s.NAME);
            c1.draw();
            c1.drawShape();
            c1.sketch();
            Circle.drawShape();
            System.out.println(c1.NAME);
            Shape s1 = null;
            System.out.println("calling with null");
            s1.drawShape();

        }

}
