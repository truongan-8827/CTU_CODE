package buoi5;

import java.util.Scanner;

public class KhachHangVip extends KhachHang{
	private float tiLeGiam;
	private MyDate ngayHetHan;
	public KhachHangVip() {
		super();
		tiLeGiam=0.0f;
		ngayHetHan=new MyDate();
	}
	public KhachHangVip(KhachHangVip a) {
		super(a);
		tiLeGiam=a.tiLeGiam;
		ngayHetHan=new MyDate(a.ngayHetHan);
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		super.nhap();
		System.out.println("Nhập tỉ lệ giảm (%): "); tiLeGiam=sc.nextFloat(); sc.nextLine();
		System.out.println("Nhập ngày hết hạn vip:");
		ngayHetHan.nhap();
	}
	public void in() {
		super.in();
		System.out.println("Tỉ lệ giảm của khách hàng vip là: "+tiLeGiam+" (%)");
		System.out.print("Ngày hết hạn vip: "); ngayHetHan.in();
	}
	public float getTiLeGiam() {
		return tiLeGiam;
	}
}
