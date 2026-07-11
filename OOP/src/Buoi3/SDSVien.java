package buoi3;

import java.util.Scanner;

public class SDSVien {
	public static void main(String[] args) {
		SVien a=new SVien();
		System.out.println("Nhập sinh viên:");
		a.nhap();
		System.out.println("In ra thông tin sinh viên:");
		a.in();
		SVien a1=new SVien(a);
		System.out.println("Thêm môn LTHDT:");
		a1.them("LTHDT"); a1.ganDiem("LTHDT", "A");
		System.out.println("Thông tin SV s1;"+a1);
		a1.xoa("LTHDT");
		System.out.println("Xóa môn LTHDT:");
		System.out.println("Thông tin SV s1:"+a1);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("---TẠO DANH SÁCH SINH VIÊN---");
		System.out.println("nhập số lượng sinh viên:");
		int t; t=sc.nextInt();
		SVien[] ds=new SVien[t];
		for (int i=0;i<t;i++) ds[i]=new SVien();
		for(SVien s: ds) s.nhap();
		System.out.println("---HIỂN THỊ CÁC SINH VIÊN---");
		for(SVien s: ds) s.in();
		
		System.out.println("---CÁC SINH VIÊN BỊ CẢNH BÁO HỌC VỤ---");
		for(SVien s: ds) s.canhBaoHocVu();
		
		System.out.println("---SINH VIÊN CÓ ĐIỂM TRUNG BÌNH CAO NHẤT---");
		SVien  GPACaoNhat=ds[0];
		float maxGPA=ds[0].dtb();
		for(int i=1;i<t;i++) {
			if(maxGPA<ds[i].dtb()) {
				maxGPA=ds[i].dtb();
				GPACaoNhat=ds[i];
			}
		}
		GPACaoNhat.in();
		System.out.println("Có GPA: "+maxGPA);
		System.out.println("---SẮP XẾP SINH VIÊN THEO ALPHABET---");
		for(int i=0;i<t-1;i++ ) {
			for(int j=i+1;j<t;j++) {
				int soSanh=ds[i].FirstCharOfName()-ds[j].FirstCharOfName();
				if(soSanh>0) {
					SVien temp=ds[i];
					ds[i]=ds[j];
					ds[j]=temp;
				}
			}
		}
		for(SVien s: ds) s.in();
	}
}