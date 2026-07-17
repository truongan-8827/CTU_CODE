package De01;

import java.util.Scanner;

public class GDich {
	int mgd;
	String hten,ngay;
	boolean tthai;
	
	public GDich() {
		this.mgd = 0;
		this.hten = new String();
		this.ngay = new String();
		this.tthai = false;
	}
	
	public GDich(GDich a) {
		this.mgd = a.mgd;
		this.hten = a.hten;
		this.ngay = a.ngay;
		this.tthai = a.tthai;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma giao dich:"); mgd=sc.nextInt(); sc.nextLine();
		System.out.println("Nhap ho va ten:"); hten=sc.nextLine();
		System.out.println("Nhap ngay giao dich(ngay-thang-nam):"); ngay=sc.nextLine();
		System.out.println("Nhap trang thai giao dich:"); tthai=sc.nextBoolean();
	}
	public void in() {
		System.out.println("[Ma giao dich: " + mgd + ", ho va ten: " + hten + ", ngay giao dich: " + ngay + ", trang thai giao dich: " + tthai+"]");
	}
	
	public int getMgd() {
		return mgd;
	}
	public String getNgay() {
		return ngay;
	}
	public static void main(String[] args) {
		System.out.println("Tao va nhap doi tuong gd1");
		GDich gd1 = new GDich();
		gd1.nhap();
		System.out.print("Hien thi doi tuong gd1: ");
		gd1.in();
		System.out.println("Tao gd2 va sao chep tu gd1");
		GDich gd2 = new GDich(gd1);
		System.out.print("Hien thi doi tuong gd2: ");
		gd2.in();
	}
	public float tienVN() {
		return -1;
	}
	public String KTGDich() {
		return "GDich";
	}

	public String getThangNam() {
		return " ";
	}
}
