package buoi3;

import buoi2.Diem;

public class DoanThang {
	Diem d1,d2;
	public DoanThang() {
		d1=new Diem();
		d2= new Diem();
	}
	public DoanThang(int ax,int ay,int bx,int by) {
		d1=new Diem(ax,ay);
		d2=new Diem(bx,by);
	}
	public DoanThang(Diem a,Diem b) {
		d1=new Diem(a);
		d2=new Diem(b);
	}
	public void nhap() {
		System.out.println("Nhập tọa độ điểm thứ nhất: "); d1.nhapDiem();
		System.out.println("Nhập toạ độ điểm thứ hai: "); d2.nhapDiem();
	}
	public void hienthi() {
		System.out.println(d1 + " và "+ d2);
	}
	public String toString() {return d1+" và " +d2;}
	public void tinhTien(int dx, int dy) {
		d1.doiDiem(dx, dy);
		d2.doiDiem(dx, dy);
	}
	public double tinhDoDai() {return d1.khoangCach(d2);}
	public double tinhGocHopOx() { //góc alpha=(d1d2,Ox) nghĩa là góc luôn <=90 và >=0 
		double alpha,sin;
		sin=Math.abs((double)(d1.giaTriY()-d2.giaTriY())/this.tinhDoDai());
		alpha=Math.toDegrees(Math.asin(sin));
		return alpha;
	}
}