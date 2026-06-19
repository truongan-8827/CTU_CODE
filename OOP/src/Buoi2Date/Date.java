package Buoi2Date;

import java.util.Scanner;

public class Date {
	private int d,m,y;
	public Date() {d=12;m=6;y=2026;}
	public Date(int d1,int m1,int y1) {d=d1;m=m1;y=y1;}
	public Date(Date A) {d=A.d;m=A.m;y=A.y;}
	public Date nhapDate() {
		Scanner sc = new Scanner(System.in);
		Date D = new Date();
		while(true) {
			D.d=sc.nextInt(); D.m=sc.nextInt();D.y=sc.nextInt();
			if(D.hopLe()) return D;
			else System.out.println("Không hợp lệ! vui lòng nhập lại:");
		}
	}
	public void hienThi() {System.out.println(d+"/"+m+"/"+y);}
	public String toString() {return (d+"/"+m+"/"+y);}
	public boolean hopLe() {
		int array[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(y%400==0 || (y%4==0 && y%100!=0))
			array[2]=29;
		return ((m>0 && m<=12) && (d>0 && d<=array[m]));
	}
	public Date ngayHomSau() {
		Date tmr= new Date(d+1,m,y);
		if(!tmr.hopLe()) {
			tmr.d=1;tmr.m+=1;
			if(!tmr.hopLe()) {
				tmr.m=1;tmr.y+=1;
			}
		}
		return tmr;
	}
	public Date congNgay(int n) {
		Date oneDay=new Date(d,m,y);
		for(int i=1;i<=n;i++) {
			oneDay=oneDay.ngayHomSau();
		}
		return oneDay;
	}
}
