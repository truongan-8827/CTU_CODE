package buoi4;

import java.util.Scanner;

public class SDSVienCNTT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---TẠO DANH SÁCH SINH VIÊN CNTT---");
		System.out.println("Nhập số lượng sinh viên CNTT:");
		int n; n=sc.nextInt();
		SVienCNTT[] ds = new SVienCNTT[n];
		for(int i=0;i<n;i++) {
			ds[i] = new SVienCNTT();
			System.out.println("Nhập sinh viên thứ "+i+1);
			ds[i].nhapSVienCNTT();
		}
		sc.nextLine();
		System.out.println("Danh sách sinh viên CNTT đã nhập");
		for(SVienCNTT e : ds) e.in();
		
		System.out.println("Nhập địa chỉ email cần tìm:");
		String foundEmail; foundEmail=sc.nextLine();
		for(SVienCNTT e : ds) {
			if(e.getEmail().compareTo(foundEmail)==0) {
				System.out.println("Đã tìm thấy sinh viên CNTT, kết quả học tập của sinh viên trên: "+e.dtb());
				break;
			}
		}
	}
}
