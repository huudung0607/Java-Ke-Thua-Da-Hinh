import org.w3c.dom.css.Rect;

import java.util.*;
import java.io.*;

abstract class Person{
    private String name,address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String toString(){
        return "-----------------\n" + "Full Name : " + name + "\n" + "Address : " + address + "\n";
    }
}

class Student extends Person{
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return super.toString() + "Program : " + program + "\n" + "Year : " + year + "\n" + "Fee : " +  String.format("%.0f",fee) + " $ " + "\n";
    }
}
class Staff extends Person{
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return super.toString() + "School : " +  school + "\nPay : " + String.format("%.0f",pay) + " $\n";
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Student[] st = new Student[n];
        Staff[] sf = new Staff[m];
        sc.nextLine();
        for(int i = 0;i < n;i++){
            sc.nextLine();
            st[i] = new Student(sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine())
                    ,Integer.parseInt(sc.nextLine()));
        }
        for(int i = 0;i < m;i++){
            sc.nextLine();
            sf[i] = new Staff(sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(st, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getFee() == o2.getFee()){
                    return o1.getName().compareTo(o2.getName());
                }
                return Double.compare(o2.getFee(),o1.getFee());
            }
        });
        Arrays.sort(sf, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if(o1.getPay() == o2.getPay()){
                    return o1.getName().compareTo(o2.getName());
                }
                return Double.compare(o2.getPay(),o1.getPay());
            }
        });
        System.out.println("Student List : ");
        for(Student x : st){
            System.out.print(x);
        }
        System.out.println("-----------------");
        System.out.println("Staff List : ");
        for(Staff x : sf){
            System.out.print(x);
        }
        System.out.print("-----------------");
    }
}
