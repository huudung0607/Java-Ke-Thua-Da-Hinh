import java.util.*;
import java.io.*;
class Person{
    private String hoTen,ngaySinh,diaChi;
    Person(){}
    public Person(String hoTen,String ngaySinh,String diaChi){
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
    public void chuanHoaTen(){
        String[] arr = hoTen.trim().toLowerCase().split("\\s+");
        String res ="";
        for(var tmp : arr){
            res += Character.toUpperCase(tmp.charAt(0));
            for(int i = 1; i < tmp.length();i++){
                res += Character.toLowerCase(tmp.charAt(i));
            }
            res += " ";
        }
        hoTen = res.trim();
    }
    public void chuanHoaNS(){
        String[] ns = ngaySinh.split("/");
        if(ns[0].length() == 1){
            ns[0] = "0" + ns[0];
        }
        if(ns[1].length() == 1){
            ns[1] = "0" + ns[1];
        }
        ngaySinh = ns[0] + "/" + ns[1] + "/" + ns[2];
    }
    public String getHoTen(){
        return hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
}
class Student extends Person{
    private String msv,lop;
    private double GPA;
    public Student(String msv, String hoTen, String ngaySinh, String diaChi, String lop, double GPA){
        super(hoTen, ngaySinh, diaChi);
        this.msv = msv;
        this.lop = lop;
        this.GPA = GPA;
    }
    public void print(){
        System.out.printf("%s %s %s %s %s %.2f",msv,super.getHoTen(),super.getNgaySinh(),super.getDiaChi(),lop,GPA);
    }
}
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(sc.nextLine());
        Vector<Student> v = new Vector<>();
        for(int i = 0;i < n;i++){
            Student s = new Student(String.format("%04d",i + 1),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextDouble());
            sc.nextLine();
            s.chuanHoaNS();s.chuanHoaTen();
            v.add(s);
        }
        for(var x : v){
            x.print();
            System.out.println();
        }
    }
}
