package QuanLiTkNganHang;

import java.util.Scanner;

public class TaiKhoan {
	private String matk,tenchu,loai;
	private double sodu;
	public TaiKhoan() {
		matk = new String();
		tenchu = new String();
		loai = new String();
		sodu=0.0;
	}
	public TaiKhoan(TaiKhoan a) {
		matk = new String(a.matk);
		tenchu = new String(a.tenchu);
		loai = new String(a.loai);
		sodu=a.sodu;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã tài khoản: "); matk = sc.nextLine();
		System.out.println("Nhập tên chủ tài khoản: "); tenchu = sc.nextLine();
		System.out.println("Nhập loại (Tiết kiệm/Thanh toán): "); loai = sc.nextLine();
		System.out.println("Nhập số dư: "); sodu=Double.parseDouble(sc.nextLine());
	}
	public void in() {
		System.out.println("TaiKhoan [Mã tài khoản: " + matk + ", tên chủ: " + tenchu + ", loại: " + loai + ", số dư: " + sodu + "]");
	}
	public static void main(String[] args) {
		System.out.println(">>>>PHẦN A.");
		TaiKhoan tk1 = new TaiKhoan();
		System.out.println("Nhập thông tin đối tượng tk1:");
		tk1.nhap();
		System.out.println("Hiển thị thông tin đối tượng tk1:");
		tk1.in();
		System.out.println("Tạo đối tượng tk2 sao chép từ tk1:");
		TaiKhoan tk2 = new TaiKhoan(tk1);
		System.out.println("Thông tin đối tượng tk2:");
		tk2.in();
	}
}
