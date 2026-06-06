package Buoi1;

public class baitap3 {
	public static void main(String[] args) {
		int n,d=1;
		double m,tong=0,max=-Double.MAX_VALUE; //lấy -Max vì Min chỉ tiến gần tới 0 (đối với double)
		for (String b: args) {
			try {
				m=Double.parseDouble(b);
				// dòng 13,14 thực hiện khi không lỗi
				if(max < m) max=m;
				tong+=m;
			}
			catch(Exception e){
				System.out.println("Co "+d+" phan tu khong dung dinh dang.");
				d++;
			}		
		}
		System.out.println("\nTổng=" +tong+ ", Max=" +max );
	}
}





