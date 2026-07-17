package buoi5;

import java.util.Scanner;

public class MyDate {
	private int d,m,y;
	public MyDate() {
		d=1;y=1;m=1;
	}
	public MyDate(int d, int m, int y) {
		this.d = d;
		this.m = m;
		this.y = y;
	}
	public MyDate(MyDate D) {
		d = D.d;
		m = D.m;
		y = D.y;
	}
	public boolean hopLe() {
		int array[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(y%400==0 || (y%4==0 && y%100!=0))
			array[2]=29;
		return ((m>0 && m<=12) && (d>0 && d<=array[m]));
	}
	public MyDate nhapDate() {
		Scanner sc = new Scanner(System.in);
		MyDate D = new MyDate();
		while(true) {
			D.d=sc.nextInt(); D.m=sc.nextInt();D.y=sc.nextInt();
			if(D.hopLe()) return D;
			else System.out.println("Không hợp lệ! vui lòng nhập lại:");
		}
	}
	public void hienThi() {System.out.println(d+"/"+m+"/"+y);}
	public String toString() {return (d+"/"+m+"/"+y);}
}
