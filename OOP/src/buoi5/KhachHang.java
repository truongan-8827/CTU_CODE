package buoi5;

import java.util.Scanner;

public class KhachHang {
	private String cccd,hten,diachi;
	public KhachHang() {
		cccd = new String();
		hten = new String();
		diachi = new String();
	}
	public KhachHang(KhachHang a) {
		cccd = new String(a.cccd);
		hten = new String(a.hten);
		diachi = new String(a.diachi);
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập căn cước công dân: "); cccd=sc.nextLine();
		System.out.println("Nhập họ tên: "); hten=sc.nextLine(); 
		System.out.println("Nhập địa chỉ mua: "); diachi=sc.nextLine();
	}
	public void in() {
		System.out.println("CCCD: "+cccd+", họ và tên: "+hten+", địa chỉ: "+diachi);
	}
	public float getTiLeGiam() {
		return 0;
	}
}
