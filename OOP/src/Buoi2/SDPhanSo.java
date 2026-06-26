package Buoi2;

public class SDPhanSo {

	public static void main(String[] args) {
		System.out.println("Tao phan so a");
		PhanSo a=new PhanSo(3,7); a.chuanhoaPhanSo(); a.hienThi();
		System.out.println("Tao phan so b");
		PhanSo b=new PhanSo(4,9); b.chuanhoaPhanSo(); b.hienThi();
		PhanSo x=new PhanSo(); PhanSo y = new PhanSo();
		System.out.println("Nhap phan so x");
		x.nhapPhanSo();  x.hienThi(); 
		System.out.println("Nhap phan so y");
		y.nhapPhanSo(); y.hienThi();
		System.out.println("Gia tri x sau khi nghich dao la");
		PhanSo A=x.giaTriNghichDao(); A.hienThi();
		System.out.println("gia tri x+y la"); 
		PhanSo B=x.cong(y); B.hienThi();
		System.out.println("Tao danh sach");
		PhanSo qlds=new PhanSo();
		PhanSo[] ds=qlds.taoDS();
		qlds.hienthiDS(ds);
		System.out.println("tong cua DS la: "+qlds.tongDS(ds));
		System.out.println("phan so lon nhat la: "+qlds.maxDS(ds));
		System.out.println("DS sau khi sap xep tang dan la:");
		qlds.sapXepTang(ds); qlds.hienthiDS(ds);
	}
}
