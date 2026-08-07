package De04;

import java.util.Scanner;

public class BNCovid extends BNhan{
	private String ngay, odich, noi;
	private char loai;
	public BNCovid() {
		super();
		ngay = new String();
		loai=' ';
		odich = new String();
		noi = new String();
	}
	public BNCovid(BNCovid c) {
		super(c);
		ngay = new String(c.ngay);
		loai=c.loai;
		odich = new String(c.odich);
		noi = new String(c.noi);
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ngày cách li:"); ngay=sc.nextLine();
		System.out.print("Nhập loại (là số F(0)=0, F(2)=2,F(3)=3,..):"); loai=sc.nextLine().charAt(0);
		System.out.print("Nhập ổ dịch:"); odich=sc.nextLine();
		System.out.print("Nhập nơi:"); noi=sc.nextLine();
	}
	public void in() {
		super.in();
		System.out.println("Ngày cách li: "+ngay);
		System.out.println("Loại: F("+loai+")");
		System.out.println("Ổ dịch: "+odich);
		System.out.println("Nơi: "+noi);
	}
	public int getThoiGian() {
		String s[]=this.ngay.split("-");
		int d,m,y;
		d=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);
		y=Integer.parseInt(s[2]);
		return d+m*100+y*10000;
	}
	public static void main(String[] args) {
		System.out.print("Nhập số lượng bệnh nhân:");
		Scanner sc = new Scanner(System.in);
		int n; n=Integer.parseInt(sc.nextLine());
		BNhan[] ds = new BNhan[n];
		for(int i=0;i<n;i++) {
			System.out.println("==Nhập bênh nhân thứ "+(i+1)+"==");
			System.out.print("Chọn bệnh nhân (bệnh nhân: 1, bệnh nhân covid: 2): ");
			int x; x=Integer.parseInt(sc.nextLine());
			if(x==0) ds[i] = new BNhan();
			else ds[i] = new BNCovid();
			ds[i].nhap();
		}
		System.out.println("Thông tin tất cả bệnh nhân");
		for(int i=0;i<n;i++) {
			System.out.println(">>Thông tin bệnh nhân thứ "+(i+1));
			ds[i].in();
		}
	
		System.out.println("Các bệnh nhân covid tại ổ dịch \"Công ty Hosiden\"");
		for(int i=0;i<n;i++) {
			if(ds[i] instanceof BNCovid) {
				BNCovid temp = (BNCovid)ds[i];
				if(temp.odich.equalsIgnoreCase("cong ty hosiden")) {
					System.out.println("-"+temp.getHten());
				}
			}
		}
		
		System.out.println("Các bệnh nhân đã hết thới gian cách ly đến ngày 18-05-2021");
		for(int i=0;i<n;i++) {
			if(ds[i] instanceof BNCovid && ((BNCovid)ds[i]).getThoiGian()<=(20210504)) 
					System.out.println("-"+ds[i].getHten());
		}
	}
}