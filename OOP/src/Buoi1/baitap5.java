package Buoi1;

import java.util.Scanner;

public class baitap5 {
	public static void bac1(double b, double c) {
		if(b!=0) System.out.println("PT bậc 1 có 1 nghiệm: " + (-c/b));
		else if(c!=0) System.err.println("PT VN");
		else System.out.println("PT có vô số nghiệm");
	}
	public static void bac2(double a, double b,double c) {
		double delta;
		delta=b*b-4*a*c;
		if(delta>0) {
			double x1,x2;
			x1=(-b+Math.sqrt(delta))/(2*a);
			x2=(-b-Math.sqrt(delta))/(2*a);
			System.out.println("PT bậc 2 có hai nghiệm phân biệt " + x1 + "và " + x2);
		}
		else if(delta==0) {
			double x=-b/(2*a);
			System.out.println("PT bậc 2 có 1 nghiệm phân biệt: " + x);
		}
		else {
			System.out.println("PT vô nghiệm");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a,b,c;
		System.out.println("nhập lần lượt hệ số a,b,c trong PT ax^2+b^x+c: ");
		a=sc.nextDouble(); b=sc.nextDouble(); c=sc.nextDouble();
		if(a==0) bac1(b,c);
		else bac2(a,b,c);
	}
}
