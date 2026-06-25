package Buoi2;

import java.util.Scanner;

public class PhanSo {
	private int tu,mau;
	public PhanSo() {tu=1; mau=1;}
	public PhanSo(int tu1,int mau1) {tu=tu1; mau=mau1;}
	public PhanSo(PhanSo A) {tu=A.tu; mau=A.mau;}
	public void nhapPhanSo() {
		Scanner sc = new Scanner(System.in);
		tu=sc.nextInt();
		while(true) {
			mau=sc.nextInt();
			if(mau!=0) break;
			else System.out.println("Vui long nhap lai!");
		}
	}
	public void hienThi() {
		if(tu==0) System.out.println(0);
		else if(mau==1) System.out.println(tu); 
		else System.out.println(tu+"/"+mau);
	}
	public String toString() {
		if(tu==0) return "0";
		else if(mau==tu) return "1";
		else if(mau==1) return "tu"; 
		else return tu+"/"+mau;
	}
	public void chuanhoaPhanSo() { //*******
		int t;
		if(tu>mau) t=mau;
		else t=tu;
		for(int i=1;i<=t;i++) {
			if(tu%i==0 && mau%i==0) {tu/=i; mau/=i;}
		}
	}
	public void nghichDao() {int temp=tu; tu=mau; mau=temp;}
	public PhanSo giaTriNghichDao() {return new PhanSo(mau,tu);}
	public double tinhPhanSo() {return (double)tu/mau;}
	public boolean lonHon(PhanSo a) {
		double h,j;
		h=(double)tu/mau; j=a.tinhPhanSo(); 
		if(h>j) return true;
		else return false;
	}
	public PhanSo cong(PhanSo a) {
		int tu1=tu*a.mau+a.tu*mau;
		int mau1=mau*a.mau;
		return new PhanSo(tu1,mau1);
	}
	public PhanSo cong(int n) {return new PhanSo(tu+n*mau,mau);}
	
	public PhanSo[] taoDS() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap so luong phan tu DS");
		int n; n=sc.nextInt();
		PhanSo[] ds=new PhanSo[n];
		//cap phat bo nho cho danh sach
		for(int i=0;i<n;i++) ds[i] = new PhanSo();
		for(int i=0;i<n;i++) {
			System.out.println("nhap phan so thu "+(i+1));
			ds[i].nhapPhanSo();
		}
		return ds;
	}
	public void hienthiDS(PhanSo[] d) {
		for(int i=0;i<d.length;i++) { System.out.println("phan so thu "+(i+1)); d[i].hienThi();}
	}
	public double tongDS(PhanSo[] d) {
		double sum=0.0;
		for(int i=0;i<d.length;i++) sum+=d[i].tinhPhanSo();
		return sum;
	}
	public double maxDS(PhanSo[] d) {
		double max=d[0].tinhPhanSo();
		for(int i=0;i<d.length;i++) {if(max<d[i].tinhPhanSo()) max=d[i].tinhPhanSo();}
		return max;
	}
	public void sapXepTang(PhanSo[] d) {
		for(int i=0;i<d.length;i++)
			for(int j=i+1;j<d.length;j++) {
				if(d[i].tinhPhanSo()>d[j].tinhPhanSo()) {
					PhanSo temp=d[i];
					d[i]=d[j];
					d[j]=temp;
				}
			}
	}
}
