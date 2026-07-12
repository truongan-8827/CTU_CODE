package buoi4;

import java.util.Scanner;

public abstract class ConVat {
	private String giong,mauLong;
	private float canNang;
	public ConVat() {
		giong = new String();
		mauLong = new String();
		canNang=0.0f;
	}
	public ConVat(String giong1, String mauLong1, float canNang1) {
		giong = giong1;
		mauLong = mauLong1;
		canNang = canNang1;
	}
	public ConVat(ConVat c) {
		giong = c.giong;
		mauLong = c.giong;
		canNang = c.canNang;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giống:"); giong=sc.nextLine();
		System.out.println("Nhập màu lông:"); mauLong=sc.nextLine();
		System.out.println("Nhập cân nặng"); canNang=sc.nextFloat();
		sc.nextLine();
	}
	public void in() {
		System.out.println("Giống: "+giong+", màu lông: "+mauLong+", cân nặng: "+canNang);
	}
	public String toString() {
		return "Giống: "+giong+", màu lông: "+mauLong+", cân nặng: "+canNang;
	}
	public abstract void keu();
}
