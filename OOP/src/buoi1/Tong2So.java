package buoi1;

import java.util.Scanner;

public class Tong2So {
	static Scanner sc = new Scanner(System.in);
	public static int nhapSo() {
		String s; int soNguyen=0;
		while(true){
			s=sc.nextLine();
			try {
				soNguyen=Integer.parseInt(s);
				break;
			}
			catch(Exception e) {
				System.out.println("Lỗi vui lòng nhập lại:");
			}
		}
		return soNguyen;
	}
	public static void main(String[] args) {
		int a,b;
		System.out.println("Nhập số nguyên a: ");
		a=nhapSo();
		System.out.println("Nhập số nguyên b: ");
		b=nhapSo();
		System.out.println("Tổng 2 số a và b là: " + (a+b));
	}

}
