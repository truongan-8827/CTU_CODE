package test;

public class B extends A{
	private int x=20;
	
	public B() {
		System.out.println("Đang tạo nè ní!");
		x += getValue();
	}
	
	@Override
	public int getValue() {
		System.out.println("Hiện tại x="+x);
		return x;
	}
}