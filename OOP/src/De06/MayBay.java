package De06;

import java.util.Scanner;

public class MayBay {
	private String mamb,hang;
	private int soghe;
	private char tthai; // s/b
	public MayBay() {
		mamb = new String();
		hang = new String();
		soghe = 0;
		tthai = ' ';
	}
	public MayBay(MayBay a) {
		mamb = new String(a.mamb);
		hang = new String(a.hang);
		soghe = a.soghe;
		tthai = a.tthai;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma may bay: "); mamb=sc.nextLine();
		System.out.print("Nhap hang: "); hang=sc.nextLine();
		System.out.print("Nhap so ghe: "); soghe=sc.nextInt(); sc.nextLine();
		System.out.print("Nhap trang thai (S:san sang, B: bao tri): "); tthai=sc.nextLine().charAt(0);
	}
	public void in() {
		System.out.println("Ma may bay: "+mamb);
		System.out.println("Hang: "+hang);
		System.out.println("So ghe: "+soghe);
		if(tthai=='s' || tthai=='S') System.out.println("Trang thai: san sang");
		else System.out.println("Trang thai: bao tri");
	}
	public String getMamb() {
		return mamb;
	}
	public String getHang() {
		return hang;
	}
	public int getSoghe() {
		return soghe;
	}
	public char getTthai() {
		return tthai;
	}
	public static void main(String[] args) {
		System.out.println("Nhap thong tin may bay mb1");
		MayBay mb1 = new MayBay();
		mb1.nhap();
		System.out.println(">>>Thong tin may bay mb1");
		mb1.in();
		System.out.println("Tao mb2 sao chep tu mb1");
		MayBay mb2 = new MayBay(mb1);
		System.out.println(">>>Thong tin may bay mb2");
		mb2.in();
	}
}
