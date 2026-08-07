package test;

public class A {
	private int x=10;
	
	public A() {
		x += getValue();
	}
	
	public int getValue() {
		return x;
	}
}
