import java.io.*;
import java.util.*;

class Vehicle {
    private String ma, ten, hang, color;

    public Vehicle() {}

    public Vehicle(String ma, String ten, String hang, String color) {
        this.ma = ma;
        this.ten = ten;
        this.hang = hang;
        this.color = color;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getHang() {
        return hang;
    }

    public String getColor() {
        return color;
    }
}

class Motorbike extends Vehicle {
    private int velocity, gia;

    public Motorbike() {}

    public Motorbike(String ma, String ten, String hang, String color, int velocity, int gia) {
        super(ma, ten, hang, color);
        this.velocity = velocity;
        this.gia = gia;
    }

    public void in() {
        System.out.println(getMa() + " " + getTen() + " " + getHang() + " " + getColor() + " " + velocity + " " + gia);
    }

    public int getGia() {
        return gia;
    }
}

class Car extends Vehicle {
    private int hp, gia;

    public Car() {}

    public Car(String ma, String ten, String hang, String color, int hp, int gia) {
        super(ma, ten, hang, color);
        this.hp = hp;
        this.gia = gia;
    }

    public void in() {
        System.out.println(getMa() + " " + getTen() + " " + getHang() + " " + getColor() + " " + hp + " " + gia);
    }

    public int getGia() {
        return gia;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Motorbike> xemay = new ArrayList<>();
        List<Car> xehoi = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String hang = sc.nextLine();
            String color = sc.nextLine();
            if (ma.charAt(0) == 'X') {
                int velocity = sc.nextInt();
                int gia = sc.nextInt();
                sc.nextLine(); // consume newline
                Motorbike moto = new Motorbike(ma, ten, hang, color, velocity, gia);
                xemay.add(moto);
            } else {
                int hp = sc.nextInt();
                int gia = sc.nextInt();
                sc.nextLine(); // consume newline
                Car oto = new Car(ma, ten, hang, color, hp, gia);
                xehoi.add(oto);
            }
        }
        Collections.sort(xemay, new Comparator<Motorbike>() {
            @Override
            public int compare(Motorbike o1, Motorbike o2) {
                if(o1.getGia() != o2.getGia()){
                    return o2.getGia() - o1.getGia();
                }
                return o1.getMa().compareTo(o2.getMa());
            }
        });
        Collections.sort(xehoi, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if(o1.getGia() != o2.getGia()){
                    return o2.getGia() - o1.getGia();
                }
                return o1.getMa().compareTo(o2.getMa());
            }
        });
        System.out.println("DANH SACH OTO : ");
        for(Car x : xehoi){
            x.in();
        }
        System.out.println("DANH SACH XE MAY : ");
        for(Motorbike x : xemay){
            x.in();
        }
    }
}
