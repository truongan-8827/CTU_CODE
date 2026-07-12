package buoi4;

import java.util.Scanner;

import buoi2.Date;
import buoi3.SVien;

public class SVienCNTT extends SVien {
	private String tk,mk,email;
	public SVienCNTT() {
		super();
		tk = new String();
		mk = new String();
		email = new String();
	}
	public SVienCNTT(SVienCNTT s) {
		super((SVien)s);
		tk = s.tk;
		mk = s.mk;
		email = s.email;
	}
	public void nhapSVienCNTT() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		System.out.println("Nhập tài khoản:"); tk=sc.nextLine();
		System.out.println("Nhập mật khẩu:"); mk=sc.nextLine();
		System.out.println("Nhập email:"); email=sc.nextLine();
	}
	public void in() {
		super.in();
		System.out.println("Tài khoản: "+tk+", email: "+email);
	}
	public String toString() {
		return super.toString() +"\nTài khoản: "+tk+", email: "+email;
	}
	public void doiMatKhau(String newpass) {
		mk = new String(newpass);
	}
	public String getEmail() {
		return email;
	}
}
