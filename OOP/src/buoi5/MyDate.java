package buoi5;

import java.util.Scanner;

public class MyDate {
	private int ngay,thang,nam;
	public MyDate() {
		ngay=1;
		thang=1;
		nam=1;
	}
	public MyDate(MyDate a) {
		ngay=a.ngay;
		thang=a.thang;
		nam=a.nam;
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhập ngày: "); ngay=sc.nextInt();
		System.out.println("Nhập tháng: "); thang=sc.nextInt();
		System.out.println("Nhập năm: "); nam=sc.nextInt();
		sc.nextLine();
	}
	public void in() {
		System.out.println(ngay+"/"+thang+"/"+nam);
	}
}
