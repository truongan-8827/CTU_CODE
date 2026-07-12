package buoi4;

import java.util.Scanner;

import buoi2.Diem;

public class DiemMau extends Diem {
	private String mau;

	public DiemMau() {
		super();
		mau = new String();
	}

	public DiemMau(int x1, int y1, String c) {
		super(x1, y1);
		mau = new String(c);
	}

	public DiemMau(DiemMau a) {
		super((Diem)a);
		mau = new String(a.mau);
	}

	public void GanMau(String c) {
		mau = new String(c);
	}

	public void nhapDiemMau() {
		Scanner sc = new Scanner(System.in);
		super.nhapDiem();
		sc.nextLine();
		System.out.println("Nhập màu:");
		mau = sc.nextLine();
	}

	public void hienthi() {
		System.out.print("Tọa độ: ");
		super.hienThi();
		System.out.println("Màu: " + mau);
	}

	@Override
	public String toString() {
		return "Tọa độ: " + super.toString() + " và màu: " + mau;
	}
}