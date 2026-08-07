package test;

import java.util.Scanner;

public class covid {
	private String ngay;
	public void nhap() {
		Scanner sc= new Scanner(System.in);
		ngay=sc.nextLine();
	}
	public int chuyenNgay() {
		String s[]=this.ngay.split("-");
		int d,m,y,t;
		d=Integer.parseInt(s[0]); 
		m=Integer.parseInt(s[1]);
		y=Integer.parseInt(s[2]);
		int xet[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int hesonam=365;
		if(y%400==0 || (y%4==0 && y%100!=0)) {
			xet[2]=29;
			hesonam=366;
		}
		int temp=0;
		for(int i=1;i<=m-1;i++) temp+=xet[i];
		t=(y)*hesonam + temp + d;
		return t;
	}
	public int tinhNgay(covid b) {
		int t1=this.chuyenNgay(),t2=b.chuyenNgay();
		return (t2-t1+1);
	}
	public static void main(String[] args) {
		covid a = new covid();
		covid b = new covid();
		System.out.println("Nhập ngày mượn:");
		a.nhap();
		System.out.println("Nhập ngày trả");
		b.nhap();
		System.out.println("Tiến hành kiểm tra");
		System.out.println("Ngày mượn: "+a.chuyenNgay());
		System.out.println("Ngày trả: "+ b.chuyenNgay());
		System.out.println("Ngày sử dụng: "+a.tinhNgay(b));
		}
}
