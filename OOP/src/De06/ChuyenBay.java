package De06;

import java.util.Scanner;

public class ChuyenBay {
	private int macb;
	private String tenphicong,giodi;
	private float giave;
	private MayBay maybay;
	public ChuyenBay() {
		macb = 0;
		tenphicong = new String();
		giodi = new String();
		giave = 0.0f;
		maybay = new MayBay();
	}
	public ChuyenBay(ChuyenBay a) {
		macb = a.macb;
		tenphicong = new String(a.tenphicong);
		giodi = new String(a.giodi);
		giave = a.giave;
		maybay = new MayBay(a.maybay);
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma chuyen bay:"); macb=sc.nextInt(); sc.nextLine();
		System.out.println("Nhap ten phi cong:"); tenphicong=sc.nextLine();
		System.out.println("Nhap gio di (gio:phut):"); giodi=sc.nextLine();
		System.out.println("Nhap gia ve:"); giave=sc.nextFloat(); sc.nextLine();
		maybay.nhap();
	}
	public void in() {
		System.out.println("Ma chuyen bay: "+macb);
		System.out.println("Ten phi cong: "+tenphicong);
		System.out.println("Gio di: "+giodi);
		System.out.println("Gia ve: "+giave);
		maybay.in();
	}
	public int getGio() {
		String s[]=giodi.split(":");
		int gio,phut;
		gio=Integer.parseInt(s[0]);
		phut=Integer.parseInt(s[1]);
		return (gio*100+phut); // luon luon dung vi phut chi co toi da 2 chu so
	}
	public float getDoanhThu() {
		return giave*maybay.getSoghe();
	}
	public static void main(String[] args) {
		System.out.print("Nhap so luong chuyen bay:");
		Scanner sc = new Scanner(System.in);
		int m; m=Integer.parseInt(sc.nextLine());
		ChuyenBay ds[] = new ChuyenBay[m];
		for(int i=0;i<m;i++) {
			System.out.println(">>>Nhap chuyen bay thu "+(i+1));
			ds[i] = new ChuyenBay();
			ds[i].nhap();
		}
		System.out.println("Thong tin cac chuyen bay");
		for(int i=0;i<m;i++) {
			System.out.println(">>>Thong tin chuyen bay thu "+(i+1));
			ds[i].in();
		}
		
		System.out.println("Thong tin va so luong chuyen bay cat canh vao buoi sang(5:00-11:59) thuoc hang VietnamaAirlines");
		int dem=0;
		for(int i=0;i<m;i++) {
			if(ds[i].getGio()>=500 && ds[i].getGio()<=1159 && ds[i].maybay.getHang().equalsIgnoreCase("VietnamAirlines")) {
				System.out.println(">>>Thong tin chuyen bay thu "+(++dem)); ds[i].in();
			}
		}
		System.out.println("So luong chuyen bay la:"+dem);
		
		System.out.println("Sap xep giam dan chuyen bay theo doanh thu");
		for(int i=0;i<m;i++) {
			for(int j=i+1;j<m;j++) {
				float dt1,dt2;
				dt1 = ds[i].getDoanhThu();
				dt2 = ds[j].getDoanhThu();
				if(dt1<dt2 || (dt1==dt2 && ds[i].tenphicong.compareTo(ds[j].tenphicong)>0)) {
					ChuyenBay temp = ds[i];
					ds[i] = ds[j];
					ds[j] = temp;
				}
			}
		}
		System.out.println("--- DANH SACH SAU KHI SAP XEP ---");
		for (int i = 0; i < m; i++) {
		    System.out.println(">>> Chuyen bay thu " + (i + 1) + " (Doanh thu: " + ds[i].getDoanhThu() + "):");
		    ds[i].in();
		}
		
		float avg=0.0f;
		for(int i=0;i<m;i++) avg+=ds[i].giave;
		avg/=m;
		System.out.println("Gia ve may bay trung binh: "+ avg);
		System.out.println("Thong tin chuyen bay co gia ve cao hon trung binh");
		dem=0;
		for(int i=0;i<m;i++)
			if(ds[i].giave>avg) {
				System.out.println(">>>Thong tin chuyen bay so "+(++dem));
				System.out.println("Ma Chuyen bay: "+ds[i].macb);
				System.out.println("Ten phi cong: "+ds[i].tenphicong);
				System.out.println("Gia ve: "+ds[i].giave);
			}
	}
}
