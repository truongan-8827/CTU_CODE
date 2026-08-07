package De05;

import java.util.Scanner;

public class PhuongTien {
	private String mapt,dongxe,ngaydk;
	private char tthai;
	public PhuongTien() {
		mapt = new String();
		dongxe = new String();
		ngaydk = new String();
		tthai=' ';
	}
	public PhuongTien(PhuongTien a) {
		mapt = new String(a.mapt);
		dongxe = new String(a.dongxe);
		ngaydk = new String(a.ngaydk);
		tthai=a.tthai;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma phuong tien: "); mapt=sc.nextLine();
		System.out.print("Nhap dong xe: "); dongxe=sc.nextLine();
		System.out.print("Nhap ngay/thang/nam dang ki: "); ngaydk=sc.nextLine();
		System.out.print("Nhap trang thai (H: hoat dong, B: bao tri): "); tthai=sc.nextLine().charAt(0);
	}
	public void in() {
		System.out.println("Ma phuong tien: "+mapt);
		System.out.println("Dong xe: "+dongxe);
		System.out.println("Ngay dang ki: "+ngaydk);
		if(tthai=='H' || tthai=='h') System.out.println("Trang thai: hoat dong");
		else System.out.println("Trang thai: bao tri");
	}
	public char getTThai() {
		return tthai;
	}
	public String getNgaydk() {
		return ngaydk;
	}
	public String getDongXe() {
		return dongxe;
	}
	public static void main(String[] args) {
		PhuongTien p1 = new PhuongTien();
		System.out.println("Nhap phuong tien p1");
		p1.nhap();
		System.out.println(">>>Thong tin phuong tien p1");
		p1.in();
		System.out.println("Tao phuong tien p2 sao chep tu p1");
		PhuongTien p2 = new PhuongTien(p1);
		System.out.println(">>>Thong tin phuong tien p2");
		p2.in();
	}
}
