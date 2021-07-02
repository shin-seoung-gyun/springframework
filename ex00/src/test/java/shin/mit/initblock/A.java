package shin.mit.initblock;

public class A {
	
	static{
		System.out.println("한번만 초기화 블럭");
	}
	
	{
		System.out.println("초기화 블럭");
	}
	
	private int a;

	public A(int a) {
		this.a = a;
	};
	
	public A() {
	};
	
}
