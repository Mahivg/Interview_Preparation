package com.vg;


import com.vg.inheritance.Circle;
import com.vg.inheritance.Shape;

public class Test {


        public static void main(String[] args){

            Shape s = new Circle();
            Circle c1 = new Circle();
            s.draw();
            s.drawShape();
            Shape.drawShape();
            System.out.println(s.NAME);
            c1.draw();
            c1.drawShape();
            Circle.drawShape();
            System.out.println(c1.NAME);

        }

}
