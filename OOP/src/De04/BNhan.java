package De04;

import java.util.Scanner;

public class BNhan {
	private String hten;
	private boolean gtinh;
	private int nsinh;
	private float cnang;
	public BNhan() {
		hten = new String();
		gtinh = false;
		nsinh = 0;
		cnang = 0.0f;
	}
	public BNhan(BNhan a) {
		hten = new String(a.hten);
		gtinh = a.gtinh;
		nsinh = a.nsinh;
		cnang = a.cnang;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập họ và tên:"); hten=sc.nextLine();
		System.out.print("Nhập giới tính (Nam:true, nữ:false):"); gtinh=sc.nextBoolean();
		System.out.print("Nhập năm sinh:"); nsinh=sc.nextInt();
		System.out.print("Nhập cân nặng:"); cnang=sc.nextFloat(); sc.nextLine();
	}
	public void in() {
		System.out.println("-Họ và tên: "+hten );
		if(gtinh) System.out.println("-Giới tính: Nam");
		else System.out.println("-Giới tính: Nữ");
		System.out.println("-Năm sinh: "+nsinh);
		System.out.println("-Cân nặng: "+cnang +" (kg)");
	}
	public String getHten() {
		return hten;
	}
	public static void main(String[] args) {
		System.out.println("Nhập bệnh nhân bn1");
		BNhan bn1 = new BNhan();
		bn1.nhap();
		System.out.println(">>>Thông tin bệnh nhân bn1");
		bn1.in();
		
		System.out.println("Tạo bn2 sao chép từ bn1");
		BNhan bn2 = new BNhan(bn1);
		System.out.println(">>>Thông tin bệnh nhân bn2");
		bn2.in();
	}
}	