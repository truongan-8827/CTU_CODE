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
		this.chuanhoaPhanSo();
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
	public void chuanhoaPhanSo() {
		//UCLN
		int a=tu,b=mau,r;
		while(b!=0) {
			r=a%b; a=b; b=r;
		}
		tu/=a; mau/=a; //phan so da chuan hoa
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
		PhanSo PS = new PhanSo(tu*a.mau+a.tu*mau,mau*a.mau);
		PS.chuanhoaPhanSo();
		return PS;
	}
	public PhanSo tru(PhanSo a) {
		PhanSo PS = new PhanSo(tu*a.mau-a.tu*mau,mau*a.mau);
		PS.chuanhoaPhanSo();
		return PS;
	}
	public PhanSo nhan(PhanSo a) {
		PhanSo PS = new PhanSo(tu*a.tu,mau*a.mau);
		PS.chuanhoaPhanSo();
		return PS;
	}
	public PhanSo chia(PhanSo a) {
		PhanSo PS = new PhanSo(tu*a.mau,mau*a.tu);
		PS.chuanhoaPhanSo();
		return PS;
	}
	
	public PhanSo cong(int n) {
		PhanSo PS = new PhanSo(tu+n*mau,mau);
		PS.chuanhoaPhanSo();
		return PS;
	}
	public PhanSo tru(int n) {
		PhanSo PS = new PhanSo(tu-n*mau,mau);
		PS.chuanhoaPhanSo();
		return PS;
	}
	public PhanSo nhan(int n) {
		PhanSo PS = new PhanSo(tu*n,mau);
		PS.chuanhoaPhanSo();
		return PS;
	}
	public PhanSo chia(int n) {
		PhanSo PS = new PhanSo(tu,mau*n);
		PS.chuanhoaPhanSo();
		return PS;
	}
	
	public PhanSo[] taoDS() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap so luong phan tu DS");
		int n; n=sc.nextInt();
		PhanSo[] ds=new PhanSo[n];
		for(int i=0;i<n;i++) {
			ds[i] = new PhanSo();
			System.out.println("nhap phan so thu "+(i+1));
			ds[i].nhapPhanSo();
			ds[i].chuanhoaPhanSo();
		}
		return ds;
	}
	public void hienthiDS(PhanSo[] d) {
		for(int i=0;i<d.length;i++) { System.out.println("phan so thu "+(i+1)); d[i].hienThi();}
	}
	public PhanSo tongDS(PhanSo[] d) {
		PhanSo PS = new PhanSo(0,1);
		for(int i=0;i<d.length;i++) {
			PS=PS.cong(d[i]);
		}
		return PS;
	}
	public PhanSo maxDS(PhanSo[] d) {
		double max=d[0].tinhPhanSo();
		int count=0;
		for(int i=0;i<d.length;i++) {
			if(max<d[i].tinhPhanSo()) {
				max=d[i].tinhPhanSo();
				count=i;
			}
		}
		return new PhanSo(d[count]);
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
