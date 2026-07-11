package buoi3;

import java.util.Scanner;

import buoi2.Date;

public class SVien {
	private String mssv,hten;
	private Date ngaySinh;
	private int n;
	private String mon[],diem[];
	public SVien() {
		mssv= new String();
		hten= new String();
		ngaySinh = new Date();
		n=0;
		mon= new String[60];
		diem= new String[60];
	}
	public SVien(SVien S) {
			mssv= new String(S.mssv);
			hten= new String(S.hten);
			ngaySinh = new Date(S.ngaySinh);
			n=S.n;
			mon= new String[60];
			diem= new String[60];
			for(int i=0;i<n;i++) {
				mon[i]=new String(S.mon[i]);
				diem[i]=new String(S.diem[i]);
			}
	}
		public void nhap() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Nhập mssv:"); mssv=sc.nextLine();
			System.out.println("Nhập họ tên:"); hten=sc.nextLine();
			System.out.println("Nhập ngày sinh:"); ngaySinh=ngaySinh.nhapDate();
			System.out.println("Nhập số môn:"); n=sc.nextInt();
			sc.nextLine();
			if(n>60) n=60;
			for(int i=0;i<n;i++) {
				System.out.println("Nhập môn thứ "+(i+1)+": ");
				mon[i]=sc.nextLine();
				System.out.print("Nhập điểm môn "+mon[i]+": ");
				diem[i]=sc.nextLine();
			}
		}
		public void in() {
			System.out.print("["+mssv+","+hten+","+ngaySinh);
			for(int i=0;i<n;i++) {
				System.out.print(","+mon[i]+","+diem[i]);
			}
			System.out.println("]");
		}
		public String toString() {
			String S=("["+mssv+","+hten+","+ngaySinh);
			for(int i=0;i<n;i++) {
				S+=(","+mon[i]+","+diem[i]);
			}
			S+=("]");
			return S;
		}
		public float dtb() {
			float d=0.0f;
			for(int i=0;i<n;i++) {
				if(diem[i].equals("A")) d+=4.0;
				else if(diem[i].equals("B+")) d+=3.5;
				else if(diem[i].equals("B")) d+=3.0;
				else if(diem[i].equals("C+")) d+=2.5;
				else if(diem[i].equals("C")) d+=2.0;
				else if(diem[i].equals("D+")) d+=1.5;
				else if(diem[i].equals("D")) d+=1.0;
				else if(diem[i].equals("F")) d+=0.0;
			}
			return d/n;
		}
		public void them(String m) {
			if(n<60) {
				mon[n]=new String(m);
				n++;
			}
			else System.out.println("Không thể thêm do mảng đầy!");
		}
		public void ganDiem(String m,String d) {
			int i=0;
			for(i=0;i<n;i++)
				if(mon[i].equals(m)) break;
			if(i<n) diem[i]=new String(d);
			else System.out.println("Không tìm thấy");
		}
		public void xoa(String m) {
			int i=0;
			for(i=0;i<n;i++)
				if(mon[i].equals(m)) break;
			if(i<n) {//tìm thấy
				for(int j=i;j<n-1;j++) {
					mon[j]=mon[j+1];
					diem[j]=diem[j+1];
				}
				n--;
			}
			else System.out.println("không tìm thấy");
		}
		public void canhBaoHocVu() {
			for(int i=0;i<n;i++)
				if(this.dtb()<1.0) {
					System.out.println("Sinh viên: "+hten+",MSSV: "+mssv+" bị cảnh cáo học vụ");
					break;
				}
		}
		public char FirstCharOfName() {
			hten=hten.trim();
			int p=hten.lastIndexOf(" ");
			//nếu chỉ có 1 từ thì p=-1 và trả về kí tự ở index=0;
			if(p==-1) return hten.charAt(0); 
			return hten.charAt(p+1);
		}
}