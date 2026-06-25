package Buoi2;

import java.util.Scanner;

public class SDDate {

	public static void main(String[] args) {
		System.out.println("---TẠO NGÀY A---");
		Date A = new Date();
		System.out.println("Hiển thị ngày A\n"+A);
		
		System.out.println("----TẠO VÀ NHẬP NGÀY B---");
		Date B = new Date(19,6,2026);
		System.out.println("Hiển thị ngày B");
		B.hienThi();
		
		System.out.println("---TẠO NGÀY C VÀ COPY A CHO C---");
		Date C = new Date(A);
		System.out.println("Hiển thị ngày C");
		C.hienThi();
		
		System.out.println("---NHẬP NGÀY D VÀ KIỂM TRA TÍNH HỢP LỆ CỦA D---");
		Date D = new Date();
		D=D.nhapDate();
		System.out.println("Hiển thị ngày D");
		D.hienThi();
		
		System.out.println("---HIỂN THỊ NGÀY HÔM SAU CỦA A---");
		A=A.ngayHomSau(); A.hienThi();
		
		System.out.println("---HIỂN NGÀY C SAU N NGÀY---");
		System.out.println("Nhập số lượng ngày:");
		Scanner sc = new Scanner(System.in); 
		int n=sc.nextInt();
		C=C.congNgay(n);
		System.out.printf("Hiển thị ngày C sau %d ngày\n",n);
		C.hienThi();
	}

}
