package De01;

import java.util.Scanner;

public class GDichTTe extends GDich{
	float dgia;
	int sluong;
	char loai;
	float tgia;
	
	public GDichTTe() {
		super();
		this.dgia = 0.0f;
		this.sluong = 0;
		this.loai = ' ';
		this.tgia = 0.0f;
	}
	
	public GDichTTe(GDichTTe a) {
		super(a);
		this.dgia = a.dgia;
		this.sluong = a.sluong;
		this.loai = a.loai;
		this.tgia = a.tgia;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		System.out.println("Nhap don gia:"); dgia=sc.nextFloat();
		System.out.println("Nhap so luong:"); sluong=sc.nextInt(); sc.nextLine();
		System.out.println("Nhap loai:"); loai=sc.nextLine().charAt(0);
		System.out.println("Nhap ti gia:"); tgia=sc.nextFloat();
	}
	public void in() {
		super.in();
		System.out.println("[Don gia: "+dgia+", so luong: "+sluong+", loai: "+loai+", ti gia: "+tgia+"]");
	}
	public float tienVN() {
		return tgia*(dgia*sluong);
	}
	public String KTGDich() {
		return "GDichTTe";
	}
	public String getThangNam() {
		String s[]=this.getNgay().split("-");
		return s[1]+"-"+s[2];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tao danh sach, nhap so luong doi tuong:");
		int n; n=sc.nextInt();
		GDich[] ds = new GDich[n];
		for(int i=0;i<n;i++) {
			System.out.println("Chon giao dich(0) hoac giao dich tien te(1) de nhap:");
			int c; c=sc.nextInt();
			if(c==0) ds[i] = new GDich();
			else if(c==1) ds[i] = new GDichTTe();
			ds[i].nhap();
		}
		
		System.out.println("Hien thi cac giao dich va giao dich tien te");
		for(int i=0;i<n;i++) {
			System.out.println("Giao dich so "+(i+1));
			ds[i].in();
		}
		
		System.out.println("Hien thi cac ma so giao dich tien te co gia tri tren 100.000VN");
		int d=0;
		for(int i=0;i<n;i++) {
			if(ds[i].tienVN()>100000f) System.out.println((++d)+".Ma giao dich: "+ds[i].mgd);
		}
		System.out.println("Thong ke so tien cua cac giao dich tien te theo thang-nam");
		//tao mang boolean true neu la GDTT;
		boolean GDTT[] = new boolean[n];
		for(int i=0;i<n;i++)
			GDTT[i]=ds[i].KTGDich().equals("GDichTTe");
		for(int i=0;i<n;i++) {
			double sum=0.0;
			if(GDTT[i]) {
				sum=ds[i].tienVN();
				GDTT[i]=false; //neu sum roi thi cho bang false
				for(int j=i+1;j<n;j++) {
					if(GDTT[j] && ds[i].getThangNam().equals(ds[j].getThangNam())) {
						sum+=ds[j].tienVN();
						GDTT[j]=false; 
					}
				}
				System.out.println(ds[i].getThangNam()+" co tong so tien la: "+sum);
			}
		}
	}
}
