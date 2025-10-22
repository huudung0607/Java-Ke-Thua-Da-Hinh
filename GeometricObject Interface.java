import org.w3c.dom.css.Rect;

import java.util.*;
import java.io.*;
interface GeometricObject{
    public double getArea();
    public double getPerimeter();
}

class Circle implements GeometricObject{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea(){
        return 3.14 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "-----------------------\nRadius : " + String.format("%.02f", radius) + "\nPerimeter : " + String.format("%.02f", this.getPerimeter())
                + "\nArea : " + String.format("%.02f", this.getArea()) + "\n-----------------------";
    }
}

class Rectangle implements GeometricObject{
    private double width;
    private double length;
    public Rectangle(double width,double length){
        this.width = width;
        this.length = length;
    }
    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }
    public String toString(){
        return "-----------------------\nWidth : " + String.format("%.02f", width) + "\nLength : " + String.format("%.02f", length)
                + "\nPerimeter : " + String.format("%.02f", this.getPerimeter())
                + "\nArea : " + String.format("%.02f", this.getArea()) + "\n-----------------------";
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<Circle> circles = new Vector<>();
        Vector<Rectangle> rectangles = new Vector<>();
        for(int i = 0;i < n ;i++){
            char type = sc.next().charAt(0);
            if(type == 'C'){
                circles.add(new Circle(sc.nextDouble()));
            }
            else{
                double w = sc.nextDouble(),l = sc.nextDouble();
                rectangles.add(new Rectangle(Math.min(w,l),Math.max(w,l)));
            }
        }
        System.out.println("Circle : ");
        for(Circle x : circles){
            System.out.println(x);
        }
        System.out.println("Rectangle : ");
        for(Rectangle x : rectangles){
            System.out.println(x);
        }
    }
}
