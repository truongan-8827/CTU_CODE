package QuanLiTkNganHang;

import java.util.Scanner;

public class GiaoDich {
	private int magd;
	private String ngay,loaigd;
	private double sotien;
	private TaiKhoan tk;
	public GiaoDich() {
		magd = 0;
		ngay = new String();
		loaigd = new String();
		sotien = 0.0;
		tk = new TaiKhoan();
	}
	public GiaoDich(GiaoDich a) {
		magd = a.magd;
		ngay = new String(a.ngay);
		loaigd = new String(a.loaigd);
		sotien = a.sotien;
		tk = new TaiKhoan(a.tk);
	}
	public void nhap() {
		tk.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã giao dịch: "); magd = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập ngày-tháng-năm giao dịch: "); ngay = sc.nextLine();
		System.out.println("Nhập loại giao dịch: "); loaigd = sc.nextLine();
		System.out.println("Nhập số tiền: "); sotien = Double.parseDouble(sc.nextLine());
	}
	public void in() {
		tk.in();
		System.out.println("GiaoDich [magd=" + magd + ", ngay=" + ngay + ", loaigd=" + loaigd + ", sotien=" + sotien + "]");
	}
	public double tinhPhi() {
		return sotien*0.02;
	}
	public String getThangNam() {
		String s[]=this.ngay.split("-");
		return s[1]+"-"+s[2];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng đối tượng giao dịch:");
		int n; n = Integer.parseInt(sc.nextLine());
		GiaoDich[] ds1 = new GiaoDich[n];
		for(int i=0;i<n;i++) {
			ds1[i] = new GiaoDich();
			System.out.println("Nhập giao dịch thứ "+(i+1)+": ");
			ds1[i].nhap();
		}
		System.out.println("Hiển thị danh sách");
		for(GiaoDich e : ds1) e.in();
		
		System.out.println("Hiển thị danh sách có số tiền giao dịch >50.000.000 hoặc loại \"Rút tiền\" ");
		for(int i=0;i<n;i++) {
			if(ds1[i].sotien>50000000.0 || ds1[i].loaigd.equalsIgnoreCase("rut tien"))
				System.out.println(ds1[i].magd);
		}
		
		System.out.println("Tổng phí giao dịch theo tháng năm");
		boolean[] xet = new boolean[n];
		for(int i=0;i<n;i++) xet[i]=true;
		
		for(int i=0;i<n;i++) {
			if(xet[i]) {
				xet[i]=false;
				double sum=ds1[i].tinhPhi();
				for(int j=i+1;j<n;j++) {
					if(ds1[j].getThangNam().equals(ds1[i].getThangNam())) {
						sum+=ds1[j].tinhPhi();
						xet[j]=false;
					}
				}
				System.out.println(ds1[i].getThangNam()+" có tổng phí: "+sum);
			}
		}
		
		System.out.println("Giao dịch có số tiền lớn nhất");
		double Max = ds1[0].sotien;
		GiaoDich gd=ds1[0];
		for(int i=1;i<n;i++) {
			if(Max<ds1[i].sotien) {
				Max=ds1[i].sotien;
				gd=ds1[i];
			}
		}
		System.out.println(gd.magd+" là giao dịch có số tiền "+Max+" lớn nhất");
		
		System.out.println("Sắp xếp giao dịch theo số tiền giảm dần");
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(ds1[i].sotien<ds1[j].sotien) {
					GiaoDich temp=ds1[i];
					ds1[i]=ds1[j];
					ds1[j]=temp;
				}
			}
		}
		System.out.println("Hiển thị danh sách giảm dần số tiền");
		for(GiaoDich e : ds1) e.in();
		
		System.out.println("Thống kê tổng số tiền giao dịch theo loại gửi/rút");
		double gui=0.0,rut=0.0;
		for(int i=0;i<n;i++) {
			if(ds1[i].loaigd.equalsIgnoreCase("gui")) {
				gui+=ds1[i].sotien;
			}
			else if(ds1[i].loaigd.equalsIgnoreCase("rut")) {
				rut+=ds1[i].sotien;
			}
		}
		System.out.println("Tổng số tiền gửi là: "+gui);
		System.out.println("Tổng số tiền rút là: "+rut);
	}
}
