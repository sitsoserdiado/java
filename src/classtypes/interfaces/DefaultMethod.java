package classtypes.interfaces;

interface MyInterface {
	public void myMethod1();
	
	default void myMethod2() {
		System.out.println("myMethod2()");
	}
}

public class DefaultMethod implements MyInterface {
	public void myMethod1() {
		System.out.println("myMethod1()");
	}

	public static void main(String[] args) {
		DefaultMethod obj = new DefaultMethod();
		obj.myMethod1();
		obj.myMethod2(); // myMethod2() 메소드를 구현하지 않았지만 디폴트 메소드이기 때문에 호출할 수 있다.
	}

}
