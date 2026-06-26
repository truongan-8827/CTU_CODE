package Buoi3;

import java.util.Scanner;

import Buoi2.PhanSo;

public class Gach {
	private String maSo,mau;
	private int n,a,b;
	private long giaMotHop;
	public Gach() { maSo="00";mau="den"; n=1; a=1; b=1; giaMotHop=2;}
	public Gach(String maSo1,String mau1,int n1,int a1,int b1,long giaMotHop1 ) { 
		maSo=maSo1;mau=mau1; n=n1; a=a1; b=b1; giaMotHop=giaMotHop1;
	}
	public Gach(Gach A) { 
		maSo=A.maSo;mau=A.mau; n=A.n; a=A.a; b=A.b; giaMotHop=A.giaMotHop;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		maSo=sc.nextLine();mau=sc.nextLine(); n=sc.nextInt(); a=sc.nextInt(); b=sc.nextInt(); giaMotHop=sc.nextLong();
	}
	public void hienThi() {
		System.out.println("Ma so: " +maSo+",mau: "+mau+",so luong: "+n+",kich thuoc"+a+"x"+b+",gia mot hop: "+giaMotHop);
	}
	public double giaBanLe(){// cao hon 20%
		return 1.2*this.giaMotHop;
	}
	public int dienTich() {
		return this.n*this.a*this.b;
	}
	public int soLuongHop(int D,int N) {
		// ta co 2 TH neu chieu DAI theo chieu DAI DTich
		// va chieu DAI theo chieu RONG DTich
		int t1 = (int)(Math.ceil((double)D/this.a)*Math.ceil((double)N/this.b));
		int t2 = (int)(Math.ceil((double)D/this.b)*Math.ceil((double)N/this.a));
		if(t1>t2) return t2;
		else return t1;
	}
	public Gach[] taoDS() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap so luong phan tu DS");
		int n; n=sc.nextInt();
		Gach[] ds=new Gach[n];
		for(int i=0;i<n;i++) {
			ds[i] = new Gach();
			System.out.println("nhap phan so thu "+(i+1));
			ds[i].nhap();
		}
		return ds;
	}
	public void hienThiDS(Gach[] ds) {
		for(int i=0;i<ds.length;i++) {
			System.out.println("Loai gach so"+(i+1));
			ds[i].hienThi();
		}
	}
}
