package buoi4;

import java.util.Scanner;

public class SDConVat {
	public static void main(String[] args) {
		System.out.println("---TẠO DANH SÁCH CON VẬT---");
		System.out.println("Nhập số lượng con vật:");
		Scanner sc = new Scanner(System.in);
		int n; n=sc.nextInt();
		ConVat[] ds = new ConVat[n];
		System.out.println("Nhập con bò(1), heo(2), dê(3), gà(4)");
		for(int i=0;i<n;i++) {
			System.out.println("Vui lòng chọn số:");
			int x; x=sc.nextInt();
			if(x==1) {
				ds[i] = new Bo();
				ds[i].nhap();
			}
			else if(x==2) {
				ds[i] = new Heo();
				ds[i].nhap();
			}
			else if(x==3) {
				ds[i] = new De();
				ds[i].nhap();
			}
			else if(x==4) {
				ds[i] = new Ga();
				ds[i].nhap();
			}
		}
		System.out.println("Danh sách các con vật");
		for(ConVat e : ds) e.in();
		
		System.out.println("Tiếng kêu của các con vật trong danh sách trên:");
		for(ConVat e : ds) e.keu();
	}
}
