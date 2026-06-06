package Buoi1;

import java.util.Scanner;

public class baitap8 {
	public static int dem(int X,int ds[]) {
		int d=0;
		for (int i : ds) {
			if(i==X) d++;
		}
		return d;
	}
	public static void sapXepTangDan(int ds[]) {
		int k,l,temp;
		for(k=0;k<ds.length-1;k++)
			for(l=k+1;l<ds.length;l++)
				if(ds[k]>ds[l]) {
					temp=ds[k];
					ds[k]=ds[l];
					ds[l]=temp;
				}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int j,x,n,DS[];
		System.out.println("nhap so phan tu danh sach: ");
		n=sc.nextInt();
		DS=new int[n];
		System.out.println("nhap lan luot cac phan tu: ");
		for(j=0;j<n;j++) {
			DS[j]=sc.nextInt();
		}
		System.out.println("nhap vao so nguyen x");
		x=sc.nextInt();
		int demso=dem(x,DS);
		System.out.println("\nSo luong so x co trong ds la: " + demso);
		sapXepTangDan(DS);
		System.out.println("Danh sach sau khi sap xep tang dan: ");
		for (int i : DS) {
			System.out.print(i+" ");
		}
	}

}
