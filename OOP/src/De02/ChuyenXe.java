package De02;

import java.util.Scanner;

public class ChuyenXe extends Xe{
	private int msx;
	private String tenlx;
	private String nden;
	private float dthu;
	
	public ChuyenXe() {
		super();
		msx=0;
		tenlx=new String();
		nden=new String();
		dthu=0.0f;
	}
	
	public ChuyenXe(ChuyenXe e) {
		super(e);
		msx=e.msx;
		tenlx=new String(e.tenlx);
		nden=new String(e.nden);
		dthu=e.dthu;
	}
	
	@Override
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		super.nhap();
		System.out.println("Nhap ma so chuyen xe:"); msx=sc.nextInt(); sc.nextLine();
		System.out.println("Nhap ten nguoi lai xe:"); tenlx=sc.nextLine();
		System.out.println("Nhap noi den:"); nden=sc.nextLine();
		System.out.println("Nhap doanh thu:"); dthu=sc.nextFloat(); 
		sc.nextLine();
	}
	
	@Override
	public void in() {
		super.in();
		System.out.println("Ma so xe: "+msx+", ten nguoi lai: "+tenlx+", noi den: "+nden+", doanh thu:"+dthu);
	}
	
	public float getDthu() {
		return dthu;
	}

	public int getMsx() {
		return msx;
	}
	
	public String getThangNam() {
		String s[]=this.getNgay().split("-");
		return s[1]+"-"+s[2];
	}
	
	public float loiNhuan() {
		return 0.3f*dthu;
	}

	public static void main(String[] args) {
		System.out.println("Nhap so luong chuyen xe:");
		Scanner sc=new Scanner(System.in);
		int m; m=sc.nextInt();
		ChuyenXe[] ds1=new ChuyenXe[m];
		for(int i=0;i<m;i++) {
			ds1[i]=new ChuyenXe();
			System.out.println("Nhap chuyen xe thu "+(i+1));
			ds1[i].nhap();
		}
		for(int i=0;i<m;i++) {
			System.out.println("Thong tin cua chuyen xe thu "+(i+1));
			ds1[i].in();
		}
		//Một chuyến xe bị huỷ khi xe đó không được phép lưu hành. 
		//Hiển thị tất cả mã số "chuyến xe bị huỷ hoặc có doanh thu dưới 100.000."
		System.out.println("Tat ca ma so xe bi huy hoac danh thu duoi 100.000");
		for(int i=0;i<m;i++) {
			int count=1;
			if(ds1[i].getTthai()=='K' || ds1[i].getDthu()<100.0f) {
				System.out.println("Ma so xe thu "+(count++)+": "+ds1[i].getMsx());
			}
		}
		boolean xet[]=new boolean[m];
		for(int i=0;i<m;i++) {
			if(ds1[i].getTthai()!='K') xet[i]=true;
			else xet[i]=false;
		}
		for(int i=0;i<m;i++) {
			if(xet[i]) {
				float sum=ds1[i].loiNhuan();
				xet[i]=false;
				for(int j=i+1;j<m;j++) {
					if(xet[j] && ds1[j].getThangNam().equals(ds1[i].getThangNam())) {
						sum+=ds1[j].loiNhuan();
						xet[j]=false;
					}
				}
				System.out.println(ds1[i].getThangNam()+" co loi nhuan: "+sum);
			}	
		}
	}
}
