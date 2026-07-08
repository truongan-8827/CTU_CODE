package Buoi3;

import java.util.Scanner;

import Buoi2.PhanSo;

public class Gach {
	private String maSo,mau;
	private int n,d,r;
	private long giaMotHop;
	public Gach() { maSo="00";mau="den"; n=1; d=1; r=1; giaMotHop=2;}
	public Gach(String maSo1,String mau1,int n1,int a1,int b1,long giaMotHop1 ) { 
		maSo=maSo1;mau=mau1; n=n1; d=a1; r=b1; giaMotHop=giaMotHop1;
	}
	public Gach(Gach A) { 
		maSo=A.maSo;mau=A.mau; n=A.n; d=A.d; r=A.r; giaMotHop=A.giaMotHop;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã số:");
		maSo=sc.nextLine();
		System.out.print("Nhập màu:");
		mau=sc.nextLine(); 
		System.out.print("Nhập số lượng:");
		n=sc.nextInt(); 
		System.out.print("Nhập chiều dài:");
		d=sc.nextInt(); 
		System.out.print("Nhập chiều rộng:");
		r=sc.nextInt(); 
		System.out.print("Nhập giá hộp:");
		giaMotHop=sc.nextLong();
	}
	public void hienThi() {
		System.out.println("Mã số: " +maSo+",màu: "+mau+",số lượng: "+n+",kích thước: "+d+"x"+r+",giá một hộp: "+giaMotHop);
	}
	public String toString() {return "Mã số: " +maSo+",màu: "+mau+",số lượng: "+n+",kích thước: "+d+"x"+r+",giá một hộp: "+giaMotHop;}
	public double giaBanLe(){// cao hon 20%
		return 1.2*this.giaMotHop;
	}
	public int dienTich() {
		return this.n*this.d*this.r;
	}
	public int soLuongHop(int D,int N) {
		// ta co 2 TH neu chieu DAI theo chieu DAI DTich
		// va chieu DAI theo chieu RONG DTich
		int t1 = (int)Math.ceil((Math.ceil((double)D/this.d)*Math.ceil((double)N/this.r))/n); 
		int t2 = (int)Math.ceil((Math.ceil((double)D/this.r)*Math.ceil((double)N/this.d))/n);
		if(t1>t2) return t2;
		else return t1;
//	}
	// fix lại phần này.
	public Gach[] taoDS() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhập số loại gạch: ");
		int n; n=sc.nextInt();
		Gach[] ds=new Gach[n];
		for(int i=0;i<n;i++) {
			ds[i] = new Gach();
			System.out.println("Nhập loại gạch thứ "+(i+1));
			ds[i].nhap();
		}
		return ds;
	}
	public void hienThiDS(Gach[] ds) {
		for(int i=0;i<ds.length;i++) {
			System.out.println("Loại gạch số "+(i+1));
			ds[i].hienThi();
		}
	}
	public double chiPhiLot() {
		int dtich=this.dienTich();
		return (double)this.giaBanLe()/dtich;
	}
	public Gach GachCPMin(Gach[] a) {
		double min=a[0].chiPhiLot();
		int count=0;
		for(int i=1;i<a.length;i++) {
			if(min>a[i].chiPhiLot()) {
				min=a[i].chiPhiLot();
				count=i;
			}
		}
		Gach b = new Gach(a[count]);
		return b;
	}
	public void hienThiDSCP(Gach[] a,int d,int r) {
		for(int i=0;i<a.length;i++) {
			System.out.println("Loại gạch số "+(i+1));
			a[i].hienThi();
			System.out.println("Chi phí cho loại này: "+(a[i].soLuongHop(d, r)*a[i].giaMotHop));
		}
	}
}
