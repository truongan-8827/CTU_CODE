package Buoi3;

public class SDGach {
	public static void main(String[] args) {
		Gach xuly= new Gach(); // đối tượng trung gian
		
		System.out.println("---NHẬP DANH SÁCH---");
		Gach[] ds= xuly.taoDS();
		System.out.println("---HIỂN THỊ DANH SÁCH CÁC LOẠI GẠCH---");
		xuly.hienThiDS(ds);
		
		System.out.println("---LOẠI GẠCH CÓ CHI PHÍ LÓT(GIÁ/DIỆN TÍCH) THẤP NHẤT---");
		System.out.println(xuly.GachCPMin(ds));
		System.out.println("Khi đó chi phi của loại gạch này là: "+ xuly.GachCPMin(ds).chiPhiLot());
		
		System.out.println("---DANH SACH CHI PHI KHI LOT CHIEU DAI 20(M) VÀ NGANG 5(M)---");
		xuly.hienThiDSCP(ds, 20, 5);
	}
}
