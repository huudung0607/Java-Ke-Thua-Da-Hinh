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
        System.out.printf("%s %s %s %s %s %.2f\n",msv,super.getHoTen(),super.getNgaySinh(),super.getDiaChi(),lop,GPA);
    }

    public double getGPA() {
        return GPA;
    }

    public String getMsv() {
        return msv;
    }

    public String getLop() {
        return lop;
    }
}
class Teacher extends Person{
    private String mgv,khoa,lop;
    private int luong;
    public Teacher(String mgv,String hoTen, String ngaySinh,String diaChi,String khoa, int luong,String lop){
        super(hoTen, ngaySinh, diaChi);
        this.mgv = mgv;
        this.khoa = khoa;
        this.luong = luong;
        this.lop = lop;
    }
    public void print(){
        System.out.printf("%s %s %s %s %s %d %s\n",mgv,super.getHoTen(),super.getNgaySinh(),super.getDiaChi(),khoa,luong,lop);
    }

    public String getLop() {
        return lop;
    }

    public int getLuong() {
        return luong;
    }
    public String getMgv() {
        return mgv;
    }
}
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(sc.nextLine());
        Vector<Student> hocSinh = new Vector<>();
        Vector<Teacher> giaoVien = new Vector<>();
        for(int i = 0;i < n;i++){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String ns = sc.nextLine();
            String diaChi = sc.nextLine();
            if(ma.charAt(0) == 'G'){
                String khoa = sc.nextLine();
                int luong = Integer.parseInt(sc.nextLine());
                String lop = sc.nextLine();
                Teacher gv = new Teacher(ma,ten,ns,diaChi,khoa,luong,lop);
                gv.chuanHoaTen();gv.chuanHoaNS();
                giaoVien.add(gv);
            }
            else{
                String lop = sc.nextLine();
                double gpa = Double.parseDouble(sc.nextLine());
                Student hs = new Student(ma,ten,ns,diaChi,lop,gpa);
                hs.chuanHoaTen();hs.chuanHoaNS();
                hocSinh.add(hs);
            }
        }
        String lop = sc.nextLine();
        System.out.println("DANH SACH GIAO VIEN PHU TRACH LOP " + lop + " : ");
        for(Teacher x : giaoVien){
            if(x.getLop().equals(lop)){
                x.print();
            }
        }
        System.out.println("DANH SACH SINH VIEN LOP " + lop + " : ");
        for(Student x : hocSinh){
            if(x.getLop().equals(lop)){
                x.print();
            }
        }
    }
}
