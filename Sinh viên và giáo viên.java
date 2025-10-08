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
    public String getTen(){
        String []arr = hoTen.split("\\s+");
        String tenChinh = arr[arr.length - 1];
        for(int i = 0;i < arr.length - 1;i++){
            tenChinh += " " + arr[i];
        }
        return tenChinh;
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
class Teacher extends Person{
    private String mgv,khoa;
    private int luong;
    public Teacher(String mgv,String hoTen, String ngaySinh,String diaChi,String khoa, int luong){
        super(hoTen, ngaySinh, diaChi);
        this.mgv = mgv;
        this.khoa = khoa;
        this.luong = luong;
    }
    public void print(){
        System.out.printf("%s %s %s %s %s %d",mgv,super.getHoTen(),super.getNgaySinh(),super.getDiaChi(),khoa,luong);
    }
}
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(sc.nextLine());
        Vector<Student> hs = new Vector<>();
        Vector<Teacher> tc = new Vector<>();
        for(int i = 0;i < n;i++){
            String ma,ten,ns,diachi,lop,khoa;
            double gpa;int luong;
            ma = sc.nextLine();
            ten = sc.nextLine();
            ns = sc.nextLine();
            diachi = sc.nextLine();
            if(ma.charAt(0) == 'G'){
                khoa = sc.nextLine();
                luong = sc.nextInt();
                sc.nextLine();
                Teacher gv = new Teacher(ma,ten,ns,diachi,khoa,luong);
                gv.chuanHoaNS();gv.chuanHoaTen();
                tc.add(gv);
            }
            else{
                lop = sc.nextLine();
                gpa = sc.nextDouble();
                sc.nextLine();
                Student s = new Student(ma,ten,ns,diachi,lop,gpa);
                s.chuanHoaNS();s.chuanHoaTen();
                hs.add(s);
            }
        }
        System.out.println("DANH SACH GIAO VIEN : ");
        for(var x : tc){
            x.print();
            System.out.println();
        }
        System.out.println("DANH SACH SINH VIEN : ");
        for(var x : hs){
            x.print();
            System.out.println();
        }
    }
}
