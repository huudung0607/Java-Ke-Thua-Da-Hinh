import org.w3c.dom.css.Rect;

import java.util.*;
import java.io.*;
interface Movable{
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
}
class MovablePoint implements Movable{
    private int x,y,xSpeed,ySpeed;
    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        this.y -= this.ySpeed;
    }

    @Override
    public void moveDown() {
        this.y += this.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x -= this.xSpeed;
    }

    @Override
    public void moveRight() {
        this.x += this.xSpeed;
    }
    public String toString(){
        return this.x + " " + this.y + "\n";
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Vector<MovablePoint> v = new Vector<>();
        for(int i = 0;i < n ;i++){
            int x = sc.nextInt(), y = sc.nextInt(), xSpeed = sc.nextInt(), ySpeed = sc.nextInt();
            MovablePoint point = new MovablePoint(x,y,xSpeed,ySpeed);
            int q = sc.nextInt();
            sc.nextLine();
            while(q-- > 0) {
                String s = sc.next();
                if (s.equals("Down")) {
                    point.moveDown();
                } else if (s.equals("Up")) {
                    point.moveUp();
                } else if (s.equals("Left")) {
                    point.moveLeft();
                }
                else point.moveRight();
            }
            v.add(point);
        }
        for(MovablePoint x : v){
            System.out.print(x);
        }
    }
}
