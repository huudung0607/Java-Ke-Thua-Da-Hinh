import org.w3c.dom.css.Rect;

import java.util.*;
import java.io.*;
class Point{
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void setXY(double x,double y){
        this.x = x;
        this.y = y;
    }
}
class MovablePoint extends Point{
    private double xSpeed,ySpeed;
    private int move;
    public MovablePoint(double x, double y,double xSpeed,double ySpeed,int move) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.move = move;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    public String toString(){
        return "X : " + String.format("%.2f",super.getX() + xSpeed * move) + "\nY : " + String.format("%.2f",super.getY() + ySpeed * move) +
                "\nX Speed : " + String.format("%.2f",xSpeed) + "\nY Speed : " + String.format("%.2f",ySpeed) + "\n-------------------\n";
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<MovablePoint> v = new Vector<>();
        for(int i = 0;i < n ;i++){
            MovablePoint point = new MovablePoint(sc.nextDouble(), sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextInt());
            v.add(point);
        }
        for(MovablePoint x : v){
            System.out.print(x);
        }
    }
}
