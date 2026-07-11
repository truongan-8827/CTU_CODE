package buoi1;

import java.util.Scanner;

public class HienThiTen {
	public static int firstName(String s) {
		s.trim();
		int temp=s.lastIndexOf(' ');
		return temp;
	}
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		String name;
		System.out.println("Nhap ho va ten: ");
		name=sc.nextLine();
		n=firstName(name);
		if(n==-1) System.out.println("\nten: "+name);
		else {
			name=name.substring(n+1);
			System.out.println("\nten: "+name);
		}
	}

}
