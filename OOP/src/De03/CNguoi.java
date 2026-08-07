package De03;

import java.util.Scanner;

public class CNguoi {
	private String id,hten,ngay;
	private char phai; //M:Nam, F:Nu
	public CNguoi() {
		id=new String();
		hten=new String();
		ngay=new String();
	 	phai=' ';
	}
	public CNguoi(CNguoi a) {
		id=new String(a.id);
		hten=new String(a.hten);
		ngay=new String(a.ngay);
		phai=a.phai;
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap ID:"); id=sc.nextLine();
		System.out.println("Nhap ho va ten:"); hten=sc.nextLine();
		System.out.println("Nhap ngay-thang-nam:"); ngay=sc.nextLine();
		System.out.println("Nhap phai(M/F):"); phai=sc.nextLine().charAt(0);
	}
	public void in() {
		System.out.println("-ID: "+id+", ho va ten: "+hten+", ngay "+ngay+", phai: "+phai);
	}
	public String getTenLop() {
		return "CNguoi";
	}
	public String getHten() {
		return hten;
	}
	public String getNgay() {
		return ngay;
	}
	public long tinhLuong() {
		return 0;
	}
	public float getFloatYear() {
		String[] s=this.getNgay().split("-");
		float d=Float.parseFloat(s[0])/30f/12f;
		float m=Float.parseFloat(s[1])/12f;
		float y=Float.parseFloat(s[2]);
		return d+m+y;
	}
	public int getTuoi() {
		float current=2026f+7/12f+23/30f/12f;
		float NamSinh=this.getFloatYear();
		return (int)(current-NamSinh);
	}
	public long getBThang() {
		return 0;
	}
	public String getMua() {
		return "";
	}
	public String getCLB() {
		return "";
	}
	public static void main(String[] args) {
		System.out.println("Tao va nhap doi tuong c1");
		CNguoi c1=new CNguoi();
		c1.nhap();
		System.out.println("Thong tin doi tuong c1");
		c1.in();
		
		System.out.println("Tao doi tuong c2 sao chep tu c1");
		CNguoi c2=new CNguoi(c1);
		System.out.println("Thong tin doi tuong c2");
		c2.in();
	}
}
