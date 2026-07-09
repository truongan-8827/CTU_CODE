package Buoi3;

import java.util.Scanner;

public class SDGach {
	public static void main(String[] args) {
		
		System.out.println("---NHẬP DANH SÁCH---");
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhập số loại gạch: ");
		int n; n=sc.nextInt();
		Gach[] ds=new Gach[n];
		for(int i=0;i<n;i++) {
			ds[i] = new Gach();
			System.out.println("Nhập loại gạch thứ "+(i+1));
			ds[i].nhap();
		}
		
		System.out.println("---HIỂN THỊ DANH SÁCH CÁC LOẠI GẠCH---");
		for (Gach g : ds) {g.hienThi();}
		
		System.out.println("---LOẠI GẠCH CÓ CHI PHÍ LÓT(GIÁ/DIỆN TÍCH) THẤP NHẤT---");
		float min=ds[0].CPTrenDienTich();
		Gach gachChiPhiThapNhat=ds[0];
		for(int i=1;i<n;i++) {
			float temp=ds[i].CPTrenDienTich();
			if(min>temp) {
				min=temp;
				gachChiPhiThapNhat=ds[i];
			}
		}
		gachChiPhiThapNhat.hienThi();
		System.out.println("Khi đó chi phi của loại gạch này là: "+min);
		
		System.out.println("---DANH SACH CHI PHI KHI LOT CHIEU DAI 2000(CM) VÀ NGANG 500(CM)---");
		for (Gach g : ds) {
			float chiPhi=(float)g.getGiaMotHop()*g.soLuongHop(2000, 500);
			System.out.println("Mã số: "+g.getmaSo()+", có chi phí là: "+chiPhi);
		}
	}
}
