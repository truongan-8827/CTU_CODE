package De03;

import java.util.Scanner;

public class CThu extends CNguoi {
	private int so;
	private String vtri;
	private long bthang;
	private String mua;
	private String clbo;

	public CThu() {
		super();
		so = 0;
		vtri = new String();
		bthang = 0l;
		mua = new String();
		clbo = new String();
	}

	public CThu(CThu a) {
		super(a);
		so = a.so;
		vtri = new String(a.vtri);
		bthang = a.bthang;
		mua = new String(a.mua);
		clbo = new String(a.clbo);
	}

	@Override
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so ao:");
		so = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap vi tri:");
		vtri = sc.nextLine();
		System.out.println("Nhap so ban thang:");
		bthang = sc.nextLong();
		sc.nextLine();
		System.out.println("Nhap mua giai:");
		mua = sc.nextLine();
		System.out.println("Nhap cau lac bo:");
		clbo = sc.nextLine();
	}

	@Override
	public void in() {
		super.in();
		System.out.println("-So ao: " + so + ", vi tri: " + vtri + ", so ban thang: " + bthang + ", mua giai: " + mua
				+ ", cau lac bo: " + clbo);
	}

	public long tinhLuong() {
		long t = 0;
		if (vtri.equals("thu mon"))
			t = (10000000 + bthang * 500000);
		else if (vtri.equals("hau ve"))
			t = (11000000 + bthang * 500000);
		else if (vtri.equals("trung ve"))
			t = (11500000 + bthang * 500000);
		else if (vtri.equals("tien ve"))
			t = (12000000 + bthang * 500000);
		else if (vtri.equals("tien dao"))
			t = (14000000 + bthang * 500000);
		return (long) (0.9 * t);
	}

	public String getTenLop() {
		return "CThu";
	}

	public long getBThang() {
		return bthang;
	}

	public String getMua() {
		return mua;
	}

	public String getCLB() {
		return clbo;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong danh sach (nguoi va cau thu):");
		int n;
		n = sc.nextInt();
		CNguoi[] ds = new CNguoi[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Chon doi tuong muon nhap con nguoi(1), cau thu(2):");
			int x;
			x = sc.nextInt();
			if (x == 1)
				ds[i] = new CNguoi();
			else if (x == 2)
				ds[i] = new CThu();
			ds[i].nhap();
		}

		System.out.println("Thong tin danh sach");
		for (CNguoi e : ds)
			e.in();

		System.out.println("Thong tin tien luong cac cau thu");
		{
			for (int i = 0; i < n; i++) {
				if (ds[i].tinhLuong() != 0) {
					System.out.println(ds[i].getHten() + " co luong la " + ds[i].tinhLuong());
				}
			}
		}

		// luu mang boolean true doi voi cau thu
		boolean[] xetCauThu = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (ds[i].getTenLop().equals("CThu"))
				xetCauThu[i] = true;
			else
				xetCauThu[i] = false;
		}
		// co the su dung (doi tuong)instanceof(ten class) tra ve true hoac false, thay
		// vi boolean
		System.out.println("Thong tin so ban thang cac cau thu theo do tuoi");
		for (int i = 0; i < n; i++) {
			if (xetCauThu[i]) {
				int tuoi1 = ds[i].getTuoi();
				long bthang1 = 0L, bthang2 = 0L, bthang3 = 0L;
				xetCauThu[i] = false;
				for (int j = i; j < n; j++) {
					if (ds[j].getMua().equals(ds[i].getMua()) && ds[j].getCLB().equals(ds[i].getCLB())) {
						int tuoi2 = ds[j].getTuoi();
						xetCauThu[j] = false;
						if (tuoi2 >= 18 && tuoi2 <= 24)
							bthang1 += ds[j].getBThang();
						else if (tuoi2 >= 25 && tuoi2 <= 28)
							bthang2 += ds[j].getBThang();
						else if (tuoi2 > 28)
							bthang3 += ds[j].getBThang();
					}
				}
				System.out.println("----" + ds[i].getMua() + "----" + ds[i].getCLB() + "----");
				System.out.println("Ban thang o do tuoi 18-24 la: " + bthang1);
				System.out.println("Ban thang o do tuoi 25-28 la: " + bthang2);
				System.out.println("Ban thang o do tuoi >28 la: " + bthang3);
			}
		}
	}
}
