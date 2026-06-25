package Buoi3;

public class SDSVien {
	public static void main(String[] args) {
		SVien s=new SVien();
		System.out.println("Nhập sinh viên:");
		s.nhap();
		System.out.println("in ra thông tin sinh viên:");
		SVien s1=new SVien(s);
		System.out.println("thêm môn LTHDT:");
		s1.them("LTHDT"); s1.ganDiem("LTHDT", "A");
		System.out.println("Thông tin SV s1;"+s1);
		s1.xoa("LTHDT");
		System.out.println("Thông tin SV s1:"+s1);
	}
}
// viết thêm hàm lấy tên, sắp xếp danh sách sv theo tên
// tìm dtb cao nhất
// làm mảng ds svien
// thống kê số sinh viên khá giỏi và xuất sắc
// thêm và xóa một số đối tượng sinh viên
// tìm kiếm sv theo tên hoặc mssc