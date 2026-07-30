package buoi5;

import java.util.Scanner;

public class HoaDon {
	private String maso,tenHangHoa;
	private int soluong;
	private float dongia;
	private KhachHang kh;
	private MyDate ngayLapHD;
	public HoaDon() {
		maso = new String();
		tenHangHoa = new String();
		soluong = 0;
		dongia= 0.0f;
		kh = new KhachHang();
		ngayLapHD = new MyDate();
	}
	public HoaDon(HoaDon a) {
		maso = new String(a.maso);
		tenHangHoa = new String(a.tenHangHoa);
		soluong = a.soluong;
		dongia= a.dongia;
		kh = new KhachHang(a.kh);
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã số: "); maso=sc.nextLine();
		System.out.println("Nhập tên hàng hóa: "); tenHangHoa=sc.nextLine();
		System.out.println("Nhập số lượng: "); soluong=sc.nextInt();
		System.out.println("Nhập đơn giá: "); dongia=sc.nextFloat();
		sc.nextLine();
		System.out.println("Chọn (1) nếu khách hàng, chọn (2) nếu là khách hàng vip:");
		int c; c=sc.nextInt(); sc.nextLine();
		if(c==1) {
			kh.nhap();
		}
		else if(c==2) {
			kh=new KhachHangVip();
			kh.nhap();
		}
		System.out.println("Nhập ngày, tháng, năm thành lập hóa đơn:");
		ngayLapHD.nhap();
	}
	public void in() {
		System.out.println("Mã số: "+maso+", hàng hóa: "+tenHangHoa+", số lượng: "+soluong+", đơn giá: "+dongia);
		kh.in();
		System.out.print("Ngày thành lập hóa đơn: "); ngayLapHD.in();
	}
}
