import org.w3c.dom.css.Rect;

import java.util.*;
import java.io.*;

class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return 3.14 * radius * radius;
    }
}

class Cylinder extends Circle{
    private double height;
    public Cylinder(String color,double radius,double height){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea() * height;
    }
    public String toString(){
        return "Color : " + super.getColor() + "\nHeight : " + String.format("%.2f",height) + "\nRadius : " + String.format("%.2f",super.getRadius())
                + "\nVolume : " + String.format("%.2f",getVolume()) + "\n-------------------";
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Vector<Cylinder> v = new Vector<>();
        for(int i = 0;i < n ;i++){
            Cylinder cylinder = new Cylinder(sc.next(),sc.nextDouble(),sc.nextDouble());
            v.add(cylinder);
        }
        Collections.sort(v, new Comparator<Cylinder>() {
            @Override
            public int compare(Cylinder o1, Cylinder o2) {
                if(o1.getVolume() == o2.getVolume()){
                    return o1.getColor().compareTo(o2.getColor());
                }
                return Double.compare(o2.getVolume(),o1.getVolume());
            }
        });
        for(Cylinder x : v){
            System.out.println(x);
        }
    }
}
