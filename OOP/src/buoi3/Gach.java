package buoi3;

import java.util.Scanner;

public class Gach {
	private String maSo,mau;
	private int soLuong,d,r;
	private long giaMotHop;
	public Gach() { maSo=new String();mau=new String(); soLuong=1; d=1; r=1; giaMotHop=2;}
	public Gach(String maSo1,String mau1,int n1,int a1,int b1,long giaMotHop1 ) { 
		maSo=new String(maSo1);mau=new String(mau1); soLuong=n1; d=a1; r=b1; giaMotHop=giaMotHop1;
	}
	public Gach(Gach A) { 
		maSo=new String(A.maSo);mau=new String(A.mau); soLuong=A.soLuong; d=A.d; r=A.r; giaMotHop=A.giaMotHop;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã số:");
		maSo=sc.nextLine();
		System.out.print("Nhập màu:");
		mau=sc.nextLine(); 
		System.out.print("Nhập số lượng:");
		soLuong=sc.nextInt(); 
		System.out.print("Nhập chiều dài:");
		d=sc.nextInt(); 
		System.out.print("Nhập chiều rộng:");
		r=sc.nextInt(); 
		System.out.print("Nhập giá hộp:");
		giaMotHop=sc.nextLong();
	}
	public void hienThi() {
		System.out.println("Mã số: " +maSo+",màu: "+mau+",số lượng: "+soLuong+",kích thước: "+d+"x"+r+",giá một hộp: "+giaMotHop);
	}
	public String toString() {return "Mã số: " +maSo+",màu: "+mau+",số lượng: "+soLuong+",kích thước: "+d+"x"+r+",giá một hộp: "+giaMotHop;}
	public float giaBanLe(){// cao hon 20%
		return (float)1.2*giaMotHop/soLuong;
	}
	public int dienTich() {
		return soLuong*d*r;
	}
	public int soLuongHop(int D,int N) {
		//nếu lót chiều dài gạch theo chiều dài của diện tích.
		double t1 = (Math.ceil((double)D/d)*Math.ceil((double)N/r)); // có thể tính bằng cách (D+d-1)/d;
		//nếu lót chiều dài gạch theo chiều rộng của diện tích
		double t2 = (Math.ceil((double)D/r)*Math.ceil((double)N/d));
		// so sánh và trẩ về số lượng hộp
		double min= Math.min(t1, t2);
		return (int)Math.ceil((double)min/soLuong);
	}
	public float CPTrenDienTich() {
		return (float)giaMotHop/this.dienTich();
	}
	public String getmaSo() {return maSo;}
	public long getGiaMotHop() {return giaMotHop;}
}