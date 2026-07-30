package buoi5;

import java.util.Scanner;

public class SDHoaDon {
	public static void main(String[] args) {
		System.out.println("TẠO DANH DANH SÁCH CÁC HÓA ĐƠN");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng danh sách:");
		int n; n=sc.nextInt();
		HoaDon[] ds = new HoaDon[n];
		for(int i=0;i<n;i++) {
			ds[i] = new HoaDon();
			System.out.println("Nhập hóa đơn thứ "+(i+1)+": ");
			ds[i].nhap();
		}
		System.out.println("HIỂN THỊ DANH SÁCH HÓA ĐƠN");
		for(int i=0;i<n;i++) {
			System.out.println(">>>Hóa đơn thứ "+(i+1));
			ds[i].in();
		}
	}
}
