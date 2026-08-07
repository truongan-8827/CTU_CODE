package De05;

import java.util.Scanner;

public class ChuyenDi {
	private int macd;
	private String tentaixe,diemden;
	private float giacuoc;
	private PhuongTien p;
	public ChuyenDi() {
		p = new PhuongTien();
		macd = 0;
		tentaixe = new String();
		diemden = new String();
		giacuoc = 0.0f;
	}
	public ChuyenDi(ChuyenDi a) {
		p = new PhuongTien(a.p);
		macd = a.macd;
		tentaixe = new String(a.tentaixe);
		diemden = new String(a.diemden);
		giacuoc = a.giacuoc;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma chuyen di: "); macd=sc.nextInt(); sc.nextLine();
		System.out.print("Nhap ten tai xe: "); tentaixe=sc.nextLine();
		System.out.print("Nhap diem den: "); diemden=sc.nextLine();
		System.out.print("Nhap gia cuoc: "); giacuoc=sc.nextFloat(); sc.nextLine();
		p.nhap();
	}
	public void in() {
		System.out.println("Ma chuyen di: "+macd);
		System.out.println("Ten tai xe: "+tentaixe);
		System.out.println("Diem den: "+diemden);
		System.out.println("Gia cuoc: "+giacuoc);
		p.in();
	}
	public String getThangNam() {
		String s[] = this.p.getNgaydk().split("/");
		return s[1]+"-"+s[2];
	}
	public static void main(String[] args) {
		System.out.println("Nhap so luong chuyen di");
		Scanner sc = new Scanner(System.in);
		int m; m=Integer.parseInt(sc.nextLine());
		ChuyenDi[] ds = new ChuyenDi[m];
		for(int i=0;i<m;i++) {
			System.out.println("Nhap chuyen di thu "+(i+1));
			ds[i] = new ChuyenDi();
			ds[i].nhap();
		}
		System.out.println("Thong tin cac chuyen di");
		for(int i=0;i<m;i++) {
			System.out.println("Thong tin chuyen di thu "+(i+1));
			ds[i].in();
		}
		System.out.println("Tat ca ma so chuyen di");
		for(int i=0;i<m;i++) {
			if(ds[i].p.getTThai()=='B' || ds[i].p.getTThai()=='b' || ds[i].giacuoc<50000 )
				System.out.println("-"+ds[i].macd);
		}
		
		boolean xet[] = new boolean[m];
		for(int i=0;i<m;i++) xet[i]=true;
		
		System.out.println("Thong ke gia cuoc theo thang-nam");
		for(int i=0;i<m;i++) {
			float sum;
			if(xet[i]) {
				sum=ds[i].giacuoc;
				xet[i]=false;
				for(int j=i+1;j<m;j++) {
					if(xet[j] && ds[i].getThangNam().equals(ds[j].getThangNam()) && ds[i].p.getDongXe().equals(ds[j].p.getDongXe())) {
						sum+=ds[j].giacuoc;
						xet[j]=false;
					}
				}
				System.out.println(ds[i].getThangNam()+" dong xe "+ds[i].p.getDongXe()+" co tong gia cuoc: "+sum);
			}
		}
		
		System.out.println("Gia cuoc cao nhat cho tung diem den");
		for(int i=0;i<m;i++) xet[i]=true;
		for(int i=0;i<m;i++) {
			float max;
			String noi;
			if(xet[i]) {
				max=ds[i].giacuoc;
				noi=ds[i].diemden;
				xet[i]=false;
				for(int j=i+1;j<m;j++) {
					if(xet[j] && ds[i].diemden.equalsIgnoreCase(ds[j].diemden)) {
						if(max<ds[j].giacuoc) max=ds[j].giacuoc;
						xet[j]=false;
					}
				}
				System.out.println("Diem den "+noi+" co gia cuoc lon nhat: "+max);
			}
		}
	}
}