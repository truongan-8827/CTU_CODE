package Buoi1;

import java.util.Scanner;

public class baitap6 {
	public static boolean primeNumbers(int m) {
		int i;
		for(i=2;i<=Math.sqrt(m);i++)
			if(m%i==0) return false;
		return m>1;
	}
	public static int binary(int n,int s[]) {
		int i,d=0,t,temp=n;
		while(temp!=0) {
			t=temp%2;
			temp/=2;
			s[d]=t;
			d++;
		}
		return d;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập số nguyên: ");
		int i,dem,a=sc.nextInt();
		int[] nhiPhan = new int[100];
		if(primeNumbers(a)) {
			dem=binary(a,nhiPhan);
			System.out.print("Số "+a+" là số nguyên tố, có dạng nhị phân là: ");
			for(i=dem-1;i>=0;i--)
				System.out.print(nhiPhan[i]);
		}
		else
			System.out.println("Số "+a+" không phải là số nguyên tố");
	}

}
