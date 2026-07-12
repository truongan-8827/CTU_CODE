package buoi4;

public class SDDiemMau {
	public static void main(String[] args) {
		System.out.println("---TẠO ĐIỂM MÀU A (5,10) MÀU TRẮNG---");
		DiemMau A = new DiemMau(5, 10, "trắng");
		System.out.println("Thông tin điểm màu A");
		A.hienthi();
		System.out.println("---TẠO ĐIỂM MÀU B TỔNG QUÁT---");
		DiemMau B = new DiemMau();
		B.nhapDiem();
		System.out.println("Tọa độ điểm B sau nhập (" + B.giaTriX() + "," + B.giaTriY() + ")");
		B.doiDiem(10, 8);
		System.out.println("Thông tin tọa độ điểm B sau dời (" + B.giaTriX() + "," + B.giaTriY() + ")");
		System.out.println("Gán màu vàng cho điểm B");
		B.GanMau("Vàng");
		System.out.println("Thông tin điểm màu B: " + B);
	}
}
