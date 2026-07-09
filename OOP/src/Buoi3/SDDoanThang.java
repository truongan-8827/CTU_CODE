package Buoi3;

public class SDDoanThang {
	public static void main(String[] args) {
		Diem A=new Diem(2,5);
		Diem B=new Diem(20,35);
		DoanThang AB=new DoanThang(A,B);
		System.out.println("Đoạn AB có tọa độ:");
		AB.hienthi();
		System.out.println("Đoạn thẳng AB sau dời (5,3):");	
		AB.tinhTien(5,3);
		AB.hienthi();
		
		System.out.println("Tạo đoạn thẳng CD");
		DoanThang CD=new DoanThang();
		CD.nhap();
		System.out.println("Đoạn CD có tọa độ:");
		CD.hienthi();
		System.out.println("Độ dài đoạn CD là: "+CD.tinhDoDai());
		System.out.println("Góc của đoạn thẳng CD với trục hoành: "+ CD.tinhGocHopOx()+"(độ)");
	}
}
