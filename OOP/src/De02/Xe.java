package De02;

import java.util.Scanner;

public class Xe {
	private String soxe; 
	private String loai;
	private String ngay;
	private char tthai; //(C/K)
	
	public Xe() {
		soxe=new String();
		loai=new String();
		ngay=new String();
		tthai=' ';
	}
	public Xe(Xe e) {
		soxe =new  String(e.soxe);
		loai =new String(e.loai);
		ngay =new String(e.ngay);
		tthai = e.tthai;
	}
	
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap so xe:"); soxe=sc.nextLine();
		System.out.println("Nhap loai xe:"); loai=sc.nextLine();
		System.out.println("Nhap ngay-thang-nam:"); ngay=sc.nextLine();
		System.out.println("Nhap trang thai:"); tthai=sc.nextLine().charAt(0);
		sc.nextLine();
	}
	
	public void in() {
		System.out.println("So xe: "+soxe+", loai: "+loai+", ngay: "+ngay+", trang thai: "+tthai);
	}
	
	public char getTthai() {
		return tthai;
	}
	
	public String getNgay() {
		return ngay;
	}
	
	public static void main(String[] args) {
		System.out.println("Nhap xe x1");
		Xe x1=new Xe();
		x1.nhap();
		System.out.println("Thong tin xe x1");
		x1.in();
		System.out.println("Tao xe x2 sao chep tu x1");
		Xe x2=new Xe(x1);
		System.out.println("Thong tin xe x2");
		x2.in();
	}
}
