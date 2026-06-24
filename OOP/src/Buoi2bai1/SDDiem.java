package Buoi2bai1;

public class SDDiem {

	public static void main(String[] args) {
		System.out.println("--Tạo điểm A--");
		Diem A=new Diem(3,4);
		System.out.println("Hiển thị điểm A\n"+ A);

		
		System.out.println("--Tạo và nhập điểm B--");
		Diem B=new Diem();
		B.nhapDiem();
		System.out.println("Hiển thị điểm B");
		B.hienThi();
		
		System.out.println("--Tạo điểm C đối xứng với B qua gốc tọa độ--");
		Diem C=new Diem(-B.giaTriX(),-B.giaTriY());
		System.out.println("Hiển thị điểm C");
		C.hienThi();
		
		System.out.println("--Tạo điểm D và copy A cho D--");
		Diem D= new Diem(A);
		System.out.println("Hiển thị điểm D\n"+D);
		
		System.out.println("khoảng cách từ điểm B đến tâm 0 là:"+ B.khoangCach());
		
		System.out.println("Khoảng cách từ điểm A đến điểm B là:"+A.khoangCach(B));
	}

}
